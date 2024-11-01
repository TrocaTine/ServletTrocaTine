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

@WebServlet(name = "ExcluirPorID", value = "/excluirPorID")
public class ExcluirCategoria extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        String idParam = request.getParameter("id");

        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifique se os parâmetros são válidos
        if (idParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome e ID são obrigatórios.");
            return;
        }

        try {
            // Inserir categoria no banco de dados
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean certo = categoriaDAO.excluirCategoriaPorId(Integer.parseInt(idParam));
            Log log = new Log("Excluir", "Categoria", "delete from categoria where id = " + idParam , idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            if (certo && logCerto) {
                request.getSession().setAttribute("successMessage", "Categoria excluida com sucesso!");
                response.sendRedirect("jsp/categoria/excluidoComSucesso.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir categoria.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir categoria.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
