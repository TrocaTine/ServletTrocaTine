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

@WebServlet(name = "BuscarTagPorCor", value = "/buscarTagPorCor")
public class BuscarTagPorCor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar o parâmetro de cor da requisição
        String cor = request.getParameter("cor");

        // Verificar se o parâmetro 'cor' é válido
        if (cor == null || cor.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "A cor é obrigatória.");
            return;
        }

        try {
            // Buscar as tags pela cor
            TagDAO tagDAO = new TagDAO();
            List<Tag> tags = tagDAO.buscarTagPorCor(cor);

            // Adicionar a lista de tags como atributo da requisição
            request.setAttribute("tags", tags);

            // Encaminhar para a página JSP para exibir os resultados
            request.getRequestDispatcher("jsp/tag/listaTagsPorCor.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar tags por cor.");
        }
    }
}
