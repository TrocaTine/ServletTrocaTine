package com.example.servlettrocatine.servlet.usuario;

import com.example.servlettrocatine.DAO.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ExcluirUsuarioPorId", value = "/excluirUsuarioPorId")
public class ExcluirUsuarioPorId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        String idParam = request.getParameter("id");

        // Verifique se os parâmetros são válidos
        if (idParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome e ID são obrigatórios.");
            return;
        }

        try {
            // Inserir usuário no banco de dados
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean certo = usuarioDAO.excluirUsuarioPorId(Integer.parseInt(idParam));

            if (certo) {
                request.getSession().setAttribute("successMessage", "Usuário excluida com sucesso!");
                response.sendRedirect("jsp/usuario/excluirUsuarioPorId.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir usuário.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir usuário.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}