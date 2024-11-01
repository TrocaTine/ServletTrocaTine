package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/VerificarAdms")
public class VerificarAdmins extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("user");
        String senha = request.getParameter("senha");
        AdmDAO adminDAO = new AdmDAO();

            int idAdm = adminDAO.verificarAdmin(usuario, senha); // Obtém o ID do administrador

            if (idAdm != -1) {
                HttpSession session = request.getSession();
                session.setAttribute("idAdm", idAdm); // Armazena o idAdm na sessão
                response.sendRedirect("jsp/pagCrud.jsp");
            } else {
                // Caso o ID não seja encontrado (não deveria ocorrer)
                request.setAttribute("erroLogin", "Usuário ou senha incorretos");
                response.sendRedirect("jsp/login.jsp");
            }
        }
}
