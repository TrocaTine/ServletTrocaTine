package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.model.Adm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "InserirAdm", value = "/inserirAdm")
public class InserirAdm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Coletar dados do formulário
            int idParam = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String idUsuario = request.getParameter("idUsuario");

            // Verifique se os parâmetros são válidos
            if (nome == null || email == null || senha == null || idUsuario == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
                return;
            }
            try {
                // Inserir categoria no banco de dados
                AdmDAO admDAO = new AdmDAO();
                Adm adm = new Adm(nome, email, senha, Integer.parseInt(idUsuario));
                boolean certo = admDAO.inserirAdm(adm);

                if (certo) {
                    request.getSession().setAttribute("successMessage", "Admin adicionada com sucesso!");
                    response.sendRedirect("jsp/adm/adicionarAdm.jsp");
                } else {
                    request.setAttribute("erro", "Erro ao inserir admin.");
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir admin.");
                }
            } catch (Exception e) {
                request.setAttribute("erro", e.getMessage());
                request.getRequestDispatcher("../erro400.jsp").forward(request, response);
            }
        } catch (InternalError e) {
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("../erro400.jsp").forward(request, response);
        }

    }
}