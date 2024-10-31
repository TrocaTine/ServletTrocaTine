package com.example.servlettrocatine.servlet.categoria;

import com.example.servlettrocatine.DAO.CategoriaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdicionarPorID", value = "/adicionarPorID")
public class AdicionarCategoria extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        String nome = request.getParameter("nome");

        // Verifique se os parâmetros são válidos
        if (nome == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome é obrigatório.");
            return;
        }

        try {
            // Inserir categoria no banco de dados
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean certo = categoriaDAO.inserirCategoria(nome);

            if (certo) {
                request.getSession().setAttribute("successMessage", "Categoria adicionada com sucesso!");
                response.sendRedirect("jsp/categoria/adicionarCategoria.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir categoria.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir categoria.");
        }
    }
}
