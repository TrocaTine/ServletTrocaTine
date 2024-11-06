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

/**
 * Servlet responsável por adicionar uma nova categoria.
 */
@WebServlet(name = "AdicionarPorID", value = "/adicionarPorID")
public class AdicionarCategoria extends HttpServlet {

    /**
     * Processa a requisição POST para adicionar uma nova categoria.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Coleta o nome da categoria do formulário
        String nome = request.getParameter("nome");

        // Recupera o ID do administrador a partir da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifica se o parâmetro nome foi fornecido
        if (nome == null || nome.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome é obrigatório.");
            return;
        }

        try {
            // Inicializa o DAO da Categoria e tenta inserir a nova categoria
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean certo = categoriaDAO.inserirCategoria(nome);

            // Cria um log para o registro da operação
            Log log = new Log(
                    "Inserir",
                    "Categoria",
                    "Categoria " + nome + " foi adicionada", idAdm);

            //Inicializa o DAO do Log e tenta inserir o log
            LogDAO logDAO = new LogDAO();

            //Insere o log no banco de dados
            boolean logCerto = logDAO.inserirLog(log);

            // Verifica o resultado das operações de inserção e log e define o redirecionamento
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
