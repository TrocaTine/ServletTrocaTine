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

@WebServlet(name = "BuscarTagPorGenero", value = "/buscarTagPorGenero")
public class BuscarTagPorGenero extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar o parâmetro de gênero da requisição
        String genero = request.getParameter("genero");

        // Verificar se o parâmetro 'genero' é válido
        if (genero == null || genero.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "O gênero é obrigatório.");
            return;
        }

        try {
            // Buscar as tags pelo gênero
            TagDAO tagDAO = new TagDAO();
            List<Tag> tags = tagDAO.buscarTagPorGenero(genero);

            // Adicionar a lista de tags como atributo da requisição
            request.setAttribute("tags", tags);

            // Encaminhar para a página JSP para exibir os resultados
            request.getRequestDispatcher("jsp/tag/listaTagsPorGenero.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar tags por gênero.");
        }
    }
}
