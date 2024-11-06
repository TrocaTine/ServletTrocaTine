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

@WebServlet(name = "BuscarPorID", value = "/buscarPorID") // Define o nome e o mapeamento da URL para este servlet
public class BuscarCategoria extends HttpServlet {

    // Método que lida com as requisições GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Obtém o parâmetro "id" da URL
        String idParam = request.getParameter("id");

        // Verifica se o parâmetro "id" foi fornecido
        if (idParam == null || idParam.isEmpty()) {
            request.setAttribute("erro", "ID não fornecido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            return;
        }

        int id;
        try {
            // Converte o parâmetro "id" para inteiro
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            request.setAttribute("erro", "ID inválido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            return;
        }

        // Cria uma instância do DAO para acessar o banco de dados
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        try {
            // Chama o método buscarCategoriaPorId do DAO para buscar a categoria pelo ID
            Categoria categoria = categoriaDAO.buscarCategoriaPorId(id);

            // Verifica se a categoria foi encontrada
            if (categoria == null) {
                request.setAttribute("erro", "Categoria não encontrada.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
                return;
            }

            // Define a categoria encontrada como atributo da requisição
            request.setAttribute("categoria", categoria);

            // Redireciona para a página JSP que exibirá os dados da categoria
            request.getRequestDispatcher("jsp/categoria/buscarCategoria.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("erro", "Erro ao buscar categoria.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
