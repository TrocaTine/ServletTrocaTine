package Servlets.Admin.Servlet;

import DAO.AdmDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class VerificarAdmins extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Receber parâmetros do formulário
        String usuario = request.getParameter("user");
        String senha = request.getParameter("senha");
        AdmDAO adminDAO = new AdmDAO();
        // Verificar o resultado e redirecionar
        if (adminDAO.verificarAdmin(usuario, senha)) {
            // Login correto, redireciona para o dashboard
            response.sendRedirect("AreaRestrita/dashboard.html");
        } else {
            // Login incorreto, redireciona para a página de login com uma mensagem de erro
            request.setAttribute("erroLogin", "Usuário ou senha incorretos");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
    }
}

