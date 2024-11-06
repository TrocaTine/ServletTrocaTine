package com.example.servlettrocatine.servlet.comunidade;

import com.example.servlettrocatine.DAO.ComunidadeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "listarTodasComunidades", value = "/comunidade") // Mapeia a URL "/comunidade" para este servlet
public class ListarTodasComunidades extends HttpServlet {

    // Método que lida com requisições POST para listar todas as comunidades
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Cria uma instância do DAO para manipulação de dados de comunidade
        ComunidadeDAO comunidadeDAO = new ComunidadeDAO();

        try {
            // Lista todas as comunidades e armazena no atributo da requisição
            request.setAttribute("comunidades", comunidadeDAO.listarTodasComunidades());

            // Redireciona para a página JSP que irá exibir as comunidades
            request.getRequestDispatcher("jsp/comunidade/listarComunidade.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Caso ocorra um erro, envia um erro 500 (Internal Server Error) ao usuário
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar comunidades.");
        }
    }

    // Método que lida com requisições GET, chamando o método doPost
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chama o método doPost para lidar com a requisição GET também
        doPost(request, response);
    }
}
