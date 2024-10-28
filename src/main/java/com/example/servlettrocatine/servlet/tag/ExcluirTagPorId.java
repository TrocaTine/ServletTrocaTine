package com.example.servlettrocatine.servlet.tag;

import com.example.servlettrocatine.DAO.TagDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ExcluirTagPorId", value = "/excluirTag")
public class ExcluirTagPorId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar o parâmetro ID da requisição
        String idParam = request.getParameter("id");

        // Validar se o parâmetro ID está presente e não é vazio
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID é obrigatório para excluir a tag.");
            return;
        }

        try {
            // Converter o ID para inteiro
            int id = Integer.parseInt(idParam);

            // Excluir a tag no banco de dados
            TagDAO tagDAO = new TagDAO();
            boolean sucesso = tagDAO.excluirTagPorId(id);

            if (sucesso) {
                request.getSession().setAttribute("successMessage", "Tag excluída com sucesso!");
                response.sendRedirect("tags");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir a tag.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir a tag.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
