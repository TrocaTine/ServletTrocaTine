package com.example.servlettrocatine.servlet.categoria;

import com.example.servlettrocatine.DAO.CategoriaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Listar", value = "/categoria") // Define o nome e mapeamento da URL para este servlet
public class ListarCategoria extends HttpServlet {

    // Método que lida com as requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Cria uma instância do DAO para acessar as categorias
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        try {
            // Lista todas as categorias e armazena no atributo da requisição
            request.setAttribute("categorias", categoriaDAO.listarCategorias());

            // Redireciona para a página JSP que exibirá as categorias
            request.getRequestDispatcher("jsp/categoria/listarCategoria.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Retorna erro 500 em caso de falha ao listar categorias
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar categorias.");
        }
    }

    // Método que lida com as requisições GET, chama o doPost para reutilizar a lógica
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
