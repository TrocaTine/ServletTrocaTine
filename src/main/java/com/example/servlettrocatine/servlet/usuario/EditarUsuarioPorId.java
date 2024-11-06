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

    // Método que lida com a requisição POST para editar um usuário pelo ID
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

        // Recuperar o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verificar se os parâmetros essenciais (nome, id e idEndereco) estão presentes
        if (nome == null || idParam == null || idEndereco == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome, ID e ID do endereço são obrigatórios.");
            return;
        }

        try {
            // Criar uma instância do DAO para editar o usuário
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean certo = usuarioDAO.editarUsuarioPorId(
                    Integer.parseInt(idParam), nome, sobrenome, telefone, senha, email, cpf, dt_nascimento, Integer.parseInt(idEndereco)
            );

            // Criar o log para registrar a ação de edição
            Log log = new Log(
                    "Editar",
                    "Usuario",
                    "Usuário atualizado: Novo nome: '"+ nome +"', Novo telefone: '"+ telefone +"', Nova senha: '"+ senha +"', Novo email: '"+ email +"', Novo cpf: '"+ cpf +"', Nova data de nascimento: '"+ dt_nascimento +"', Novo id doendereco: "+ idEndereco + " para o usuário com ID: "+ idParam,
                    idAdm);

            // Criação do objeto logDAO
            LogDAO logDAO = new LogDAO();

            // Inserção do log no banco de dados
            boolean logCerto = logDAO.inserirLog(log);

            // Se a edição e o log forem bem-sucedidos, redirecionar para a página de edição com sucesso
            if (certo && logCerto) {
                request.getSession().setAttribute("successMessage", "Usuário editado com sucesso!");
                response.sendRedirect("jsp/usuario/editarUsuarioPorId.jsp");
            } else {
                // Caso ocorra algum erro ao editar o usuário, retornar erro 500
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar usuário.");
            }
        } catch (SQLException e) {
            // Caso ocorra algum erro no banco de dados, retornar erro 500
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar usuário.");
        } catch (NumberFormatException e) {
            // Caso ocorra erro ao converter os IDs para inteiro, retornar erro 400
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
