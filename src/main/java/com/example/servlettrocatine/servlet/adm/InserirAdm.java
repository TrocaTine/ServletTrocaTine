package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.DAO.SenhaHash;
import com.example.servlettrocatine.model.Adm;
import com.example.servlettrocatine.model.Log;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "InserirAdm", value = "/inserirAdm")
public class InserirAdm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        String idParam = request.getParameter("id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        SenhaHash cripto;
        try {
            cripto = new SenhaHash(senha);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        String idUsuario = request.getParameter("idUsuario");

        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifique se os parâmetros são válidos
        if (nome == null || email == null || senha == null || idUsuario == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
            return;
        }

        try {
            // Inserir categoria no banco de dados
            AdmDAO admDAO = new AdmDAO();
            Adm adm = new Adm(nome, email, cripto.getSenha(), Integer.parseInt(idUsuario));
            boolean certo = admDAO.inserirAdm(adm);

            Log log = new Log("Inserir", "Adm", "insert into adm (nome, email, senha, idusuario) values ('" + nome + "', '" + email + "', '" + cripto.getSenha() + "', " + idUsuario + ")"
            , idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            if (certo && logCerto) {
                request.getSession().setAttribute("successMessage", "Admin adicionada com sucesso!");
                response.sendRedirect("jsp/adm/adicionarAdm.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir admin.");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
