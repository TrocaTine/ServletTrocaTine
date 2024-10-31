package com.example.servlettrocatine.servlet.categoria;

import com.example.servlettrocatine.DAO.CategoriaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Listar", value = "/categoria")
public class ListarCategoria extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        try {
            // Lista as categorias e as armazena no atributo da requisição
            request.setAttribute("categorias", categoriaDAO.listarCategorias());

            // Redireciona para uma página JSP para exibir as categorias
            request.getRequestDispatcher("jsp/categoria/listarCategoria.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Você pode redirecionar para uma página de erro, se desejar
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar categorias.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chama o método doPost para lidar com a requisição
        doPost(request, response);
    }
}
