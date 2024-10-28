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

@WebServlet(name = "BuscarTagPorTamanho", value = "/buscarTagPorTamanho")
public class BuscarTagPorTamanho extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar o parâmetro de tamanho da requisição
        String tamanho = request.getParameter("tamanho");

        // Verificar se o parâmetro 'tamanho' é válido
        if (tamanho == null || tamanho.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "O tamanho é obrigatório.");
            return;
        }

        try {
            // Buscar as tags pelo tamanho
            TagDAO tagDAO = new TagDAO();
            List<Tag> tags = tagDAO.buscarTagPorTamanho(tamanho);

            // Adicionar a lista de tags como atributo da requisição
            request.setAttribute("tags", tags);

            // Encaminhar para a página JSP para exibir os resultados
            request.getRequestDispatcher("jsp/tag/listaTagsPorTamanho.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar tags por tamanho.");
        }
    }
}
