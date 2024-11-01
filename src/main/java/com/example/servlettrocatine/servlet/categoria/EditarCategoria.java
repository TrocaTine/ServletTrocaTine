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

@WebServlet(name = "EditarCatPorID", value = "/editarCatPorId")
public class EditarCategoria extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        String nome = request.getParameter("nome");
        String idParam = request.getParameter("id");

        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifique se os parâmetros são válidos
        if (nome == null || idParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome e ID são obrigatórios.");
            return;
        }

        try {
            // Inserir categoria no banco de dados
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean certo = categoriaDAO.editarCategoriaPorId(nome, Integer.parseInt(idParam));
            Log log = new Log("Editar", "Categoria", "update categoria set tipo_produto = " + nome + " where id = " + idParam , idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            if (certo && logCerto) {
                request.getSession().setAttribute("successMessage", "Categoria editada com sucesso!");
                response.sendRedirect("jsp/categoria/editarCategoria.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar categoria.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar categoria.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
