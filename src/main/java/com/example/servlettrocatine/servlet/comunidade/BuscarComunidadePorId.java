package com.example.servlettrocatine.servlet.comunidade;

import com.example.servlettrocatine.DAO.ComunidadeDAO;
import com.example.servlettrocatine.model.Comunidade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "buscarComunidadePorID", value = "/buscarComunidadePorID")
public class BuscarComunidadePorId extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idComunidade = request.getParameter("id");

        if (idComunidade == null || idComunidade.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID não fornecido.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idComunidade);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
            return;
        }

        ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
        try {
            Comunidade comunidade = comunidadeDAO.buscarComunidadePorId(id);
            if (comunidade == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Comunidade não encontrada.");
                return;
            }
            request.setAttribute("comunidades", comunidade);
            request.getRequestDispatcher("jsp/comunidade/buscarComunidadePorID.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar comunidades.");
        }
    }
}
