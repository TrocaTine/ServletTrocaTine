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

@WebServlet(name = "BuscarUsuarioPorEmail", value = "/buscarUsuarioPorEmail")
public class BuscarUsuarioPorEmail extends HttpServlet {

    // Método que lida com a requisição GET para buscar um usuário pelo e-mail
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Coletar o e-mail da requisição
        String emailParam = request.getParameter("email");

        // Verificar se o e-mail foi fornecido
        if (emailParam == null || emailParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "E-mail não fornecido.");
            return;
        }

        String email;
        try {
            // Converter o e-mail para minúsculas (padrão para comparação)
            email = emailParam.toLowerCase();
        } catch (NumberFormatException e) {
            // Caso haja erro ao processar o e-mail, retornar erro 400
            request.setAttribute("erro", "Erro: 400 - Id inválido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            return;
        }

        // Criar uma instância do DAO para buscar o usuário
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            // Buscar o usuário no banco de dados pelo e-mail
            Usuario usuario = usuarioDAO.buscarUsuarioPorEmail(email);

            // Se o usuário não for encontrado, enviar erro 404
            if (usuario == null) {
                request.setAttribute("erro", "Erro: 404 - Usuário não encontrado.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
                return;
            }

            // Armazenar o usuário encontrado na requisição para a página JSP
            request.setAttribute("usuario", usuario);

            // Redirecionar para a página de exibição do usuário encontrado
            request.getRequestDispatcher("jsp/usuario/buscarUsuarioPorEmail.jsp").forward(request, response);

        } catch (SQLException e) {
            // Em caso de erro de banco de dados, enviar erro 500
            e.printStackTrace();
            request.setAttribute("erro", "Erro: 500 - Falha ao acessar o banco de dados.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
