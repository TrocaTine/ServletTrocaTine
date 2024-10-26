package com.example.servlettrocatine.servlet.comunidade;

import com.example.servlettrocatine.DAO.ComunidadeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "listarTodasComunidades", value = "/comunidade")
public class ListarTodasComunidades extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ComunidadeDAO comunidadeDAO = new ComunidadeDAO();

        try {
            // Lista as categorias e as armazena no atributo da requisição
            request.setAttribute("comunidades", comunidadeDAO.listarTodasComunidades());

            // Redireciona para uma página JSP para exibir as categorias
            request.getRequestDispatcher("jsp/comunidade/listarComunidade.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Você pode redirecionar para uma página de erro, se desejar
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar comunidades.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chama o método doPost para lidar com a requisição
        doPost(request, response);
    }
}
