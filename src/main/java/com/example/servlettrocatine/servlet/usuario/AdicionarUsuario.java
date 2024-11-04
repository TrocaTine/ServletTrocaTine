package com.example.servlettrocatine.servlet.usuario;

import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.DAO.SenhaHash;
import com.example.servlettrocatine.DAO.UsuarioDAO;
import com.example.servlettrocatine.model.Log;
import com.example.servlettrocatine.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.regex.Pattern;

@WebServlet(name = "AdicionarUsuario", value = "/adicionarUsuario")
public class AdicionarUsuario extends HttpServlet {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
    private static final String TELEFONE_REGEX = "^[0-9]{10,15}$"; // ajuste o tamanho conforme necessário

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone").replaceAll("[\\s/]", ""); // Remove espaços e barras
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String dt_nascimento = request.getParameter("dt_nascimento");

        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        SenhaHash cripto;
        try {
            cripto = new SenhaHash(senha);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // Validar e-mail
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Email inválido. Deve estar no formato nome@gmail.com.");
            return;
        }

        // Validar telefone
        if (!Pattern.matches(TELEFONE_REGEX, telefone)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Telefone inválido. Deve conter entre 10 a 15 dígitos.");
            return;
        }

        // Criar um novo usuário
        Usuario usuario = new Usuario(nome, telefone, cripto.getSenha(), email, cpf, dt_nascimento);

        try {
            boolean certo = usuarioDAO.inserirUsuario(usuario);
            Log log = new Log("Inserir", "Usuario", "insert into usuario (nome, telefone, senha, email, cpf, dt_nascimento) values ('" + nome + "', '" + telefone + "', '" + cripto.getSenha() + "', '" + email + "', '" + cpf + "', '" + dt_nascimento + "')", idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);
            if (certo && logCerto) {
                request.getSession().setAttribute("successMessage", "Usuário adicionado com sucesso!");
                response.sendRedirect("jsp/usuario/adicionarUsuario.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir usuário.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir usuário.");
        }
    }
}