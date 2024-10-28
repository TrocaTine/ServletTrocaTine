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
import java.util.List;

@WebServlet(name = "ListarTodasTags", value = "/tags")
public class ListarTodasTags extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Instanciar o DAO
            TagDAO tagDAO = new TagDAO();

            // Buscar todas as tags
            List<Tag> tags = tagDAO.listarTodasTags();

            // Armazenar a lista de tags na requisição
            request.setAttribute("tags", tags);

            // Encaminhar para a página JSP para exibir as tags
            request.getRequestDispatcher("jsp/tag/listarTags.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar tags.");
        }
    }
}
