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

@WebServlet(name = "ListarTodasTags", value = "/tags") // Mapeia a URL "/tags" para este servlet
public class ListarTodasTags extends HttpServlet {

    // Método que lida com requisições GET para listar todas as tags
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Instanciar o DAO que irá acessar o banco de dados
            TagDAO tagDAO = new TagDAO();

            // Buscar todas as tags no banco de dados
            List<Tag> tags = tagDAO.listarTodasTags();

            // Armazenar a lista de tags no atributo da requisição para ser acessada na JSP
            request.setAttribute("tags", tags);

            // Encaminhar a requisição para a página JSP para exibir as tags
            request.getRequestDispatcher("jsp/tag/listarTags.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Se ocorrer um erro de SQL, envia um erro 500 (Internal Server Error)
            request.setAttribute("erro", "Erro: 500 - Falha ao acessar o banco de dados.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
