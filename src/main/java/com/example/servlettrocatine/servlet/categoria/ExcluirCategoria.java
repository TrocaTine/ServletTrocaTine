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

@WebServlet(name = "ExcluirPorID", value = "/excluirPorID") // Define o nome e mapeamento da URL para este servlet
public class ExcluirCategoria extends HttpServlet {

    // Método que lida com as requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Coleta o parâmetro "id" do formulário (id da categoria a ser excluída)
        String idParam = request.getParameter("id");

        // Obtém o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifica se o parâmetro ID foi fornecido
        if (idParam == null) {
            request.setAttribute("erro", "Nome e ID são obrigatórios.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            return;
        }

        try {
            // Cria uma instância do DAO da Categoria para realizar a exclusão
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean certo = categoriaDAO.excluirCategoriaPorId(Integer.parseInt(idParam));

            // Cria uma entrada de log para registrar a ação de exclusão
            Log log = new Log(
                    "Excluir",
                    "Categoria",
                    "Categoria com ID: " + idParam + " excluída", idAdm);

            // Cria uma instância do DAO de Log para inserir a entrada de log
            LogDAO logDAO = new LogDAO();

            // Insere a entrada de log no banco de dados
            boolean logCerto = logDAO.inserirLog(log);

            // Verifica se tanto a exclusão quanto o log foram realizados com sucesso
            if (certo && logCerto) {
                // Se tudo estiver certo, envia uma mensagem de sucesso para a sessão
                request.getSession().setAttribute("successMessage", "Categoria excluída com sucesso!");
                response.sendRedirect("jsp/categoria/excluidoComSucesso.jsp"); // Redireciona para a página de sucesso
            } else {
                request.setAttribute("erro", "Erro ao excluir categoria.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("erro", "Erro ao excluir categoria.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
