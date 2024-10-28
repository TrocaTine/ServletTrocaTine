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

@WebServlet(name = "InserirTag", value = "/inserirTag")
public class InserirTag extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar os parâmetros do formulário
        String genero = request.getParameter("genero");
        String cor = request.getParameter("cor");
        String tamanho = request.getParameter("tamanho");
        String qualidade = request.getParameter("qualidade");
        String idtipo_produto = request.getParameter("idtipo_produto");
        String id = request.getParameter("id");

        // Validar se todos os campos estão preenchidos
        if (genero == null || cor == null || tamanho == null || qualidade == null ||
                genero.isEmpty() || cor.isEmpty() || tamanho.isEmpty() || qualidade.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
            return;
        }

        try {
            // Criar a nova tag com os dados do formulário
            Tag novaTag = new Tag(Integer.parseInt(id), genero, cor, tamanho, qualidade, Integer.parseInt(idtipo_produto)); // ID será gerado pelo banco

            // Inserir a nova tag no banco de dados
            TagDAO tagDAO = new TagDAO();
            boolean sucesso = tagDAO.inserirTag(novaTag);

            if (sucesso) {
                request.getSession().setAttribute("successMessage", "Tag adicionada com sucesso!");
                response.sendRedirect("jsp/tag/inserirTag.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir a tag.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir a tag.");
        }
    }
}
