package com.example.servlettrocatine.servlet.usuario;

import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.DAO.UsuarioDAO;
import com.example.servlettrocatine.model.Log;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditarUsuarioPorId", value = "/editarUsuarioPorId")
public class EditarUsuarioPorId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String dt_nascimento = request.getParameter("dt_nascimento");
        String idParam = request.getParameter("id");
        String idEndereco = request.getParameter("idendereco");

        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifique se os parâmetros são válidos
        if (nome == null || idParam == null || idEndereco == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome ,ID e ID do endereço são obrigatórios.");
            return;
        }

        try {
            // Inserir usuário no banco de dados
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean certo = usuarioDAO.editarUsuarioPorId( Integer.parseInt(idParam), nome, sobrenome, telefone, senha, email, cpf, dt_nascimento, Integer.parseInt(idEndereco));
            Log log = new Log("Editar", "Usuario", "update usuario set nome = '"+ nome +"', telefone = '"+ telefone +"', senha = '"+ senha +"', email = '"+ email +"', cpf = '"+ cpf +"', dt_nascimento = '"+ dt_nascimento +"', idendereco = "+ idEndereco + " where id = "+ idParam, idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);


            if (certo && logCerto) {
                request.getSession().setAttribute("successMessage", "Usuário editado com sucesso!");
                response.sendRedirect("jsp/usuario/editarUsuarioPorId.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar usuário.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar usuário.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
