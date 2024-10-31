package com.example.servlettrocatine.servlet.categoria;

import com.example.servlettrocatine.DAO.CategoriaDAO;
import com.example.servlettrocatine.model.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.sql.SQLException;
import java.io.IOException;

@WebServlet(name = "BuscarPorID", value = "/buscarPorID")
public class BuscarCategoria extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID não fornecido.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
            return;
        }

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        try {
            Categoria categoria = categoriaDAO.buscarCategoriaPorId(id);
            if (categoria == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Categoria não encontrada.");
                return;
            }
            request.setAttribute("categoria", categoria);
            request.getRequestDispatcher("jsp/categoria/buscarCategoria.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar categoria.");
        }
    }
}
