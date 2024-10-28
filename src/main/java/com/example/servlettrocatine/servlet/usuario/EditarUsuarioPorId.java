package com.example.servlettrocatine.servlet.usuario;

import com.example.servlettrocatine.DAO.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditarUsuarioPorId", value = "/editarUsuarioPorId")
public class EditarUsuarioPorId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String dt_nascimento = request.getParameter("dt_nascimento");
        String id = request.getParameter("id");

        // Verifique se os parâmetros são válidos
        if (nome == null || id == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome e ID são obrigatórios.");
            return;
        }

        try {
            // Inserir usuário no banco de dados
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean certo = usuarioDAO.editarUsuarioPorId( Integer.parseInt(id), nome, telefone, senha, email, cpf, dt_nascimento);

            if (certo) {
                request.getSession().setAttribute("successMessage", "Usuário editado com sucesso!");
                response.sendRedirect("jsp/usuario/editarUsuarioPorId.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar usuário.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar usuário.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
