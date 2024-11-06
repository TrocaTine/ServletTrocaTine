package com.example.servlettrocatine.servlet.log;

import com.example.servlettrocatine.DAO.LogDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ListarQuerys", value = "/log") // Mapeia a URL "/log" para este servlet
public class ListarLog extends HttpServlet {

    // Método que lida com requisições POST para listar os logs
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Cria uma instância do DAO para manipulação de dados de log
        LogDAO logDAO = new LogDAO();

        try {
            // Lista todos os logs e armazena no atributo da requisição
            request.setAttribute("log", logDAO.listarLog());

            // Redireciona para a página JSP que irá exibir os logs
            request.getRequestDispatcher("jsp/log.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Caso ocorra um erro, envia um erro 500 (Internal Server Error) ao usuário
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar query.");
        }
    }

    // Método que lida com requisições GET, chamando o método doPost
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chama o método doPost para lidar com a requisição GET também
        doPost(request, response);
    }
}
