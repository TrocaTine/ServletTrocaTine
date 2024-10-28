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

@WebServlet(name = "BuscarTagPorQualidade", value = "/buscarTagPorQualidade")
public class BuscarTagPorQualidade extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar o parâmetro de qualidade da requisição
        String qualidade = request.getParameter("qualidade");

        // Verificar se o parâmetro 'qualidade' é válido
        if (qualidade == null || qualidade.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "A qualidade é obrigatória.");
            return;
        }

        try {
            // Buscar as tags pela qualidade
            TagDAO tagDAO = new TagDAO();
            List<Tag> tags = tagDAO.buscarTagPorQualidade(qualidade);

            // Adicionar a lista de tags como atributo da requisição
            request.setAttribute("tags", tags);

            // Encaminhar para a página JSP para exibir os resultados
            request.getRequestDispatcher("jsp/tag/listaTagsPorQualidade.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar tags por qualidade.");
        }
    }
}

