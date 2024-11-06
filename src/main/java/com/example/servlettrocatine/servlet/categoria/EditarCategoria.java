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

@WebServlet(name = "EditarCatPorID", value = "/editarCatPorId") // Define o nome e mapeamento da URL para este servlet
public class EditarCategoria extends HttpServlet {

    // Método que lida com as requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Coleta os dados do formulário (nome da categoria e ID)
        String nome = request.getParameter("nome");
        String idParam = request.getParameter("id");

        // Obtém o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifica se os parâmetros são válidos (nome e id não podem ser nulos)
        if (nome == null || idParam == null) {
            request.setAttribute("erro", "Nome e ID são obrigatórios.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            return;
        }

        try {
            // Cria instância do DAO da Categoria para realizar a atualização
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean certo = categoriaDAO.editarCategoriaPorId(nome, Integer.parseInt(idParam));

            // Cria uma entrada de log para registrar a ação de edição
            Log log = new Log(
                    "Editar",
                    "Categoria",
                    "Categoria " + nome + " atualizada com ID " + idParam , idAdm);

            // Cria instância do DAO de Log para inserir a entrada de log
            LogDAO logDAO = new LogDAO();

            // Insere a entrada de log no banco de dados
            boolean logCerto = logDAO.inserirLog(log);

            // Verifica se tanto a edição quanto o log foram realizados com sucesso
            if (certo && logCerto) {
                // Se tudo estiver certo, envia uma mensagem de sucesso para a sessão
                request.getSession().setAttribute("successMessage", "Categoria editada com sucesso!");
                response.sendRedirect("jsp/categoria/editarCategoria.jsp"); // Redireciona para a página de edição
            } else {
                request.setAttribute("erro", "Erro ao editar categoria.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("erro", "Erro ao editar categoria.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
