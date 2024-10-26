package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/VerificarAdms")
public class VerificarAdmins extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("user");
        String senha = request.getParameter("senha");
        AdmDAO adminDAO = new AdmDAO();
        if (adminDAO.verificarAdmin(usuario, senha)) {
            response.sendRedirect("AreaRestrita/dashboard.html");
        } else {
            request.setAttribute("erroLogin", "Usuário ou senha incorretos");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

    }
}
