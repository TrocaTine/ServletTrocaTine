package com.example.servlettrocatine.servlet.usuario;

import com.example.servlettrocatine.DAO.UsuarioDAO;
import com.example.servlettrocatine.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.sql.SQLException;
import java.io.IOException;

@WebServlet(name = "BuscarUsuarioPorId", value = "/buscarUsuarioPorId")
public class BuscarUsuarioPorId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID não fornecido.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
            return;
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);
            if (usuario == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Usuário não encontrado.");
                return;
            }
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("jsp/usuario/buscarUsuarioPorId.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao buscar usuário.");
        }
    }
}