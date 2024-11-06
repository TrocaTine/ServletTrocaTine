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

    // Método que lida com a requisição POST para listar os usuários
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Criar uma instância do DAO para acessar os dados do usuário
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            // Lista todos os usuários do banco de dados
            request.setAttribute("usuarios", usuarioDAO.listarUsuario());

            // Redireciona para a página JSP para exibir os usuários
            request.getRequestDispatcher("jsp/usuario/listarUsuario.jsp").forward(request, response);
        } catch (Exception e) {
            // Caso ocorra algum erro ao listar os usuários, imprime o erro e retorna uma resposta de erro 500
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar usuários.");
        }
    }

    // Método que lida com a requisição GET, chamando o método doPost
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chama o método doPost para processar a requisição GET, garantindo que ambos os métodos tratem a lógica da mesma forma
        doPost(request, response);
    }
}
