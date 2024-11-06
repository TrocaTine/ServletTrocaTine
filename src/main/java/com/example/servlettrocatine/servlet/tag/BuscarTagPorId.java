package com.example.servlettrocatine.servlet.tag;

import com.example.servlettrocatine.DAO.TagDAO;
import com.example.servlettrocatine.model.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BuscarTagPorId", value = "/buscarTagPorId") // Mapeia a URL "/buscarTagPorId" para este servlet
public class BuscarTagPorId extends HttpServlet {

    // Método que lida com requisições GET para buscar uma tag por ID
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Coletar o parâmetro de ID da requisição
        String idParam = request.getParameter("id");

        // Verificar se o parâmetro 'id' foi fornecido e é válido
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "O ID é obrigatório.");
            return;
        }

        try {
            // Converter o ID para um número inteiro
            int id = Integer.parseInt(idParam);

            // Criar uma instância do DAO para buscar a tag
            TagDAO tagDAO = new TagDAO();
            Tag tag = tagDAO.buscarTagPorId(id); // Busca a tag no banco de dados usando o ID

            if (tag != null) {
                // Se a tag for encontrada, adiciona a tag como atributo da requisição
                request.setAttribute("tag", tag);
                // Redireciona a requisição para a página JSP que irá exibir os detalhes da tag
                request.getRequestDispatcher("jsp/tag/buscarTag.jsp").forward(request, response);
            } else {
                // Se a tag não for encontrada, envia um erro 404 (não encontrada)
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Tag não encontrada.");
            }
        } catch (NumberFormatException e) {
            // Caso o ID não seja um número válido, envia um erro 400 (Bad Request)
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        } catch (SQLException e) {
            e.printStackTrace();
            // Caso ocorra um erro de SQL, envia um erro 500 (Internal Server Error)
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar tag por ID.");
        }
    }
}
