package com.example.servlettrocatine.servlet.usuario;

import com.example.servlettrocatine.DAO.CategoriaDAO;
import com.example.servlettrocatine.DAO.UsuarioDAO;
import com.example.servlettrocatine.model.Categoria;
import com.example.servlettrocatine.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.sql.SQLException;
import java.io.IOException;

@WebServlet(name = "BuscarUsuarioPorEmail", value = "/buscarUsuarioPorEmail")
public class BuscarUsuarioPorEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailParam = request.getParameter("email");
        if (emailParam == null || emailParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "E-mail não fornecido.");
            return;
        }

        String email;
        try {
            email = emailParam.toLowerCase();
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "E-mail inválido.");
            return;
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            Usuario usuario = usuarioDAO.buscarUsuarioPorEmail(email);
            if (usuario == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Usuário não encontrado.");
                return;
            }
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("jsp/usuario/buscarUsuarioPorEmail.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar usuário.");
        }
    }
}
