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
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome e ID são obrigatórios."); // Retorna erro 400 se faltar algum parâmetro
            return;
        }

        try {
            // Cria instância do DAO da Categoria para realizar a atualização
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean certo = categoriaDAO.editarCategoriaPorId(nome, Integer.parseInt(idParam));

            // Cria uma entrada de log para registrar a ação de edição
            Log log = new Log("Editar", "Categoria", "update categoria set tipo_produto = " + nome + " where id = " + idParam , idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            // Verifica se tanto a edição quanto o log foram realizados com sucesso
            if (certo && logCerto) {
                // Se tudo estiver certo, envia uma mensagem de sucesso para a sessão
                request.getSession().setAttribute("successMessage", "Categoria editada com sucesso!");
                response.sendRedirect("jsp/categoria/editarCategoria.jsp"); // Redireciona para a página de edição
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar categoria."); // Retorna erro 500 se algo deu errado
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar categoria."); // Retorna erro 500 em caso de falha no banco de dados
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido."); // Retorna erro 400 se o ID não for válido
        }
    }
}
