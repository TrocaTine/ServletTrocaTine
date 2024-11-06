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

@WebServlet(name = "buscarComunidadePorID", value = "/buscarComunidadePorID") // Define o nome e mapeamento da URL para este servlet
public class BuscarComunidadePorId extends HttpServlet {

    // Método que lida com as requisições GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coleta o parâmetro "id" da requisição, que é o ID da comunidade a ser buscada
        String idComunidade = request.getParameter("id");

        // Verifica se o ID foi fornecido, caso contrário, retorna erro 400
        if (idComunidade == null || idComunidade.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID não fornecido.");
            return;
        }

        int id;
        try {
            // Tenta converter o ID para um número inteiro
            id = Integer.parseInt(idComunidade);
        } catch (NumberFormatException e) {
            // Retorna erro 400 se o ID não for um número válido
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
            return;
        }

        // Cria uma instância do DAO de Comunidade para buscar a comunidade pelo ID
        ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
        try {
            // Busca a comunidade com o ID fornecido
            Comunidade comunidade = comunidadeDAO.buscarComunidadePorId(id);
            if (comunidade == null) {
                // Retorna erro 404 se a comunidade não for encontrada
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Comunidade não encontrada.");
                return;
            }

            // Armazena a comunidade encontrada no atributo da requisição
            request.setAttribute("comunidades", comunidade);

            // Redireciona para a página JSP para exibir os detalhes da comunidade
            request.getRequestDispatcher("jsp/comunidade/buscarComunidadePorID.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Retorna erro 500 em caso de falha ao acessar o banco de dados
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar comunidades.");
        }
    }
}
