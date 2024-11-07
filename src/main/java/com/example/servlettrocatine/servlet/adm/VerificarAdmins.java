package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet responsável por verificar as credenciais de um administrador.
 * Se bem-sucedido, cria uma sessão para o administrador.
 */
@WebServlet("/VerificarAdms")
public class VerificarAdmins extends HttpServlet {

    /**
     * Método doPost para processar a requisição de login do administrador.
     * Verifica o usuário e senha fornecidos e redireciona de acordo com o resultado.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Coleta o nome de usuário e a senha do formulário
        String usuario = request.getParameter("user");
        String senha = request.getParameter("senha");

        // Cria uma instância de AdmDAO para verificar as credenciais
        AdmDAO adminDAO = new AdmDAO();

        // Verifica o ID do administrador no banco de dados
        int idAdm = adminDAO.verificarAdmin(usuario, senha);

        if (idAdm != -1) {
            // Se as credenciais estiverem corretas, cria uma sessão para o administrador
            HttpSession session = request.getSession();
            session.setAttribute("idAdm", idAdm); // Armazena o idAdm na sessão

            // Redireciona para a página de CRUD
            response.sendRedirect("jsp/home.html");
        } else {
            // Se o ID não for encontrado, retorna erro de login
            request.setAttribute("ErroLogin", "Usuário ou senha incorretos");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}
