package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.DAO.SenhaHash;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/VerificarAdms")
public class VerificarAdmins extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("user");
        String senha = request.getParameter("senha");

        SenhaHash cripto;
        try {
            cripto = new SenhaHash(senha);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        AdmDAO adminDAO = new AdmDAO();

            int idAdm = adminDAO.verificarAdmin(usuario, cripto.getSenha()); // pega o ID do administrador

            if (idAdm != -1) {
            HttpSession session = request.getSession();
            session.setAttribute("idAdm", idAdm); // guarda o idAdm na sessão
            response.sendRedirect("jsp/pagCrud.jsp");
            } else {
            // se o ID não seja encontrado
            request.setAttribute("ErroLogin", "Usuário ou senha incorretos");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            }

    }
}
