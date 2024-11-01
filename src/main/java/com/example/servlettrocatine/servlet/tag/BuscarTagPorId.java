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

@WebServlet(name = "BuscarTagPorId", value = "/buscarTagPorId")
public class BuscarTagPorId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar o parâmetro de ID da requisição
        String idParam = request.getParameter("id");


        // Verificar se o parâmetro 'id' é válido
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "O ID é obrigatório.");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);  // Converter o ID para um número inteiro
            TagDAO tagDAO = new TagDAO();
            Tag tag = tagDAO.buscarTagPorId(id);

            if (tag != null) {
                // Adicionar a tag como atributo da requisição
                request.setAttribute("tag", tag);
                // Encaminhar para a página JSP para exibir os detalhes da tag
                request.getRequestDispatcher("jsp/tag/buscarTag.jsp").forward(request, response);
            } else {
                // Tag não encontrada, retornar erro 404
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Tag não encontrada.");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar tag por ID.");
        }
    }
}
