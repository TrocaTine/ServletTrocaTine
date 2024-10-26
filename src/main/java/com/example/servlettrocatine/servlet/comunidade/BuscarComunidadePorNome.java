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
import java.util.List;

@WebServlet(name = "buscarComunidadePorNome", value = "/buscarComunidadePorNome")
public class BuscarComunidadePorNome extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeComunidade = request.getParameter("nome");
        if (nomeComunidade == null || nomeComunidade.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome não fornecido.");
            return;
        }
        ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
        try {
            List<Comunidade> comunidade = comunidadeDAO.buscarComunidadePorNome(nomeComunidade);
            for (Comunidade comu : comunidade) {
                if (comu == null) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Comunidade não encontrada.");
                    return;
                }
            }

            request.setAttribute("comunidades", comunidade);
            request.getRequestDispatcher("jsp/comunidade/buscarComunidadePorNome.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar comunidades.");
        }
    }
}
