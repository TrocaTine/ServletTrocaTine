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

    // Método que lida com a requisição GET para buscar um usuário pelo ID
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Coletar o parâmetro ID da requisição
        String idParam = request.getParameter("id");

        // Verificar se o ID foi fornecido
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID não fornecido.");
            return;
        }

        int id;
        try {
            // Tentar converter o ID para inteiro
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            // Caso o ID seja inválido, retornar erro 400
            request.setAttribute("erro", "Erro: 400 - ID inválido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            return;
        }

        // Criar uma instância do DAO para buscar o usuário
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            // Buscar o usuário no banco de dados pelo ID
            Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);

            // Se o usuário não for encontrado, retornar erro 404
            if (usuario == null) {
                request.setAttribute("erro", "Erro: 404 - Usuário não encontrada.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
                return;
            }

            // Armazenar o usuário encontrado na requisição para a página JSP
            request.setAttribute("usuario", usuario);

            // Redirecionar para a página de exibição do usuário encontrado
            request.getRequestDispatcher("jsp/usuario/buscarUsuarioPorId.jsp").forward(request, response);

        } catch (SQLException e) {
            // Em caso de erro de banco de dados, retornar erro 500
            e.printStackTrace();
            request.setAttribute("erro", "Erro: 500 - Falha ao acessar o banco de dados.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
