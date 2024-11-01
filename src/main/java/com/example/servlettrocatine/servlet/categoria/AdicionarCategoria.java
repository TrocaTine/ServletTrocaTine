package com.example.servlettrocatine.servlet.categoria;

import com.example.servlettrocatine.DAO.CategoriaDAO;
import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.model.Log;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdicionarPorID", value = "/adicionarPorID")
public class AdicionarCategoria extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        String nome = request.getParameter("nome");

        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifique se os parâmetros são válidos
        if (nome == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome é obrigatório.");
            return;
        }

        try {
            // Inserir categoria no banco de dados
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean certo = categoriaDAO.inserirCategoria(nome);
            Log log = new Log("Inserir", "Categoria", "insert into categoria (tipo_produto) values ('" + nome + "')", idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            if (certo && logCerto) {
                request.getSession().setAttribute("successMessage", "Categoria adicionada com sucesso!");
                response.sendRedirect("jsp/categoria/adicionarCategoria.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir categoria.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir categoria.");
        }
    }
}
