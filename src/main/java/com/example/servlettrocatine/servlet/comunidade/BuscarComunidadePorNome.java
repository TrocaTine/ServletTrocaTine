package com.example.servlettrocatine.servlet.comunidade;

import com.example.servlettrocatine.DAO.CategoriaDAO;
import com.example.servlettrocatine.DAO.ComunidadeDAO;
import com.example.servlettrocatine.model.Categoria;
import com.example.servlettrocatine.model.Comunidade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "buscarComunidadePorNome", value = "/buscarComunidadePorNome") // Define o nome e mapeamento da URL para este servlet
public class BuscarComunidadePorNome extends HttpServlet {

    // Método que lida com as requisições GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coleta o parâmetro "nome" da requisição, que é o nome da comunidade a ser buscada
        String nomeComunidade = request.getParameter("nome");

        // Verifica se o nome foi fornecido, caso contrário, retorna erro 400
        if (nomeComunidade == null || nomeComunidade.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome não fornecido.");
            return;
        }

        // Cria uma instância do DAO de Comunidade para buscar as comunidades pelo nome
        ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
        try {
            // Busca as comunidades que correspondem ao nome fornecido
            List<Comunidade> comunidade = comunidadeDAO.buscarComunidadePorNome(nomeComunidade);

            // Verifica se a lista de comunidades está vazia e retorna erro 404 se não houver comunidades encontradas
            if (comunidade.isEmpty()) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Comunidade não encontrada.");
                return;
            }

            // Armazena as comunidades encontradas no atributo da requisição
            request.setAttribute("comunidades", comunidade);

            // Redireciona para a página JSP para exibir as comunidades encontradas
            request.getRequestDispatcher("jsp/comunidade/buscarComunidadePorNome.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Retorna erro 500 em caso de falha ao acessar o banco de dados
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar comunidades.");
        }
    }
}
