package com.example.servlettrocatine.servlet.usuario;

import com.example.servlettrocatine.DAO.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ListarUsuario", value = "/usuario")
public class ListarUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            // Lista os usuários e as armazena no atributo da requisição
            request.setAttribute("usuarios", usuarioDAO.listarUsuario());

            // Redireciona para uma página JSP para exibir os usuários
            request.getRequestDispatcher("jsp/usuario/listarUsuario.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Você pode redirecionar para uma página de erro, se desejar
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar usuários.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chama o método doPost para lidar com a requisição
        doPost(request, response);
    }
}
