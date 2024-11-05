package com.example.servlettrocatine.servlet.usuario;


import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.DAO.UsuarioDAO;
import com.example.servlettrocatine.model.Log;
import com.example.servlettrocatine.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdicionarUsuario", value = "/adicionarUsuario")
public class AdicionarUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String dt_nascimento = request.getParameter("dt_nascimento");
        int idendereco = Integer.parseInt(request.getParameter("idendereco"));
        Usuario usuario = new Usuario(nome, sobrenome, telefone, senha, email, cpf, dt_nascimento, idendereco);

        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        try {
            boolean certo = usuarioDAO.inserirUsuario(usuario);
            Log log = new Log("Inserir", "Usuario", "Usuário adicionado nome: "+ nome + " sobrenome: " + sobrenome + "telefone: " + telefone + " email: " + email + " cpf: " + cpf + " dt_nascimento: " + dt_nascimento + " idEndereco: " + idendereco,idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            if (certo && logCerto) {
                request.getSession().setAttribute("successMessage", "Usuário adicionada com sucesso!");
                response.sendRedirect("jsp/usuario/adicionarUsuario.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir usuário.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
           response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir usuário.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }

    }
}
