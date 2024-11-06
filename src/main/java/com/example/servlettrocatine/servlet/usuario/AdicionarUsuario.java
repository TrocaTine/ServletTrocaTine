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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "AdicionarUsuario", value = "/adicionarUsuario")
public class AdicionarUsuario extends HttpServlet {

    // Expressões regulares para validação
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";  // Email no formato nome@gmail.com
    private static final String TELEFONE_REGEX = "^[0-9]{2}\\s?[0-9]{5}\\s?[0-9]{4}$";// Telefone em varios formatos
    private static final String CPF_REGEX = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$"; //cpf em formato xxx.xxx.xxx-xx

    // Método para validar o email
    private boolean validarEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Método para validar o telefone
    private boolean validarTelefone(String telefone) {
        Pattern pattern = Pattern.compile(TELEFONE_REGEX);
        Matcher matcher = pattern.matcher(telefone);
        return matcher.matches();
    }

    // Método para validar o CPF
    private boolean validarCpf(String cpf) {
        Pattern pattern = Pattern.compile(CPF_REGEX);
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
    }

    // Método que lida com a requisição POST para adicionar um usuário
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
        int idendereco = Integer.parseInt(request.getParameter("idendereco"));

        // Validação de e-mail, telefone e CPF
        if (!validarEmail(email)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "E-mail deve ser do tipo nome@gmail.com.");
            return;
        }

        if (!validarTelefone(telefone)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Telefone inválido.");
            return;
        }

        if (!validarCpf(cpf)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "CPF inválido.");
            return;
        }

        // Criar um objeto Usuario com os dados coletados
        Usuario usuario = new Usuario(nome, sobrenome, telefone, senha, email, cpf, dt_nascimento, idendereco);

        // Obter o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        try {
            // Tentar inserir o usuário no banco de dados
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean certo = usuarioDAO.inserirUsuario(usuario);

            // Criar um log de inserção
            Log log = new Log("Inserir", "Usuario",
                    "Usuário adicionado nome: " + nome + " sobrenome: " + sobrenome +
                            " telefone: " + telefone + " email: " + email + " cpf: " + cpf +
                            " dt_nascimento: " + dt_nascimento + " idEndereco: " + idendereco,
                    idAdm);

            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            // Verificar se a inserção do usuário e do log foram bem-sucedidas
            if (certo && logCerto) {
                // Definir uma mensagem de sucesso e redirecionar para a página de adicionar usuário
                request.getSession().setAttribute("successMessage", "Usuário adicionado com sucesso!");
                response.sendRedirect("jsp/usuario/adicionarUsuario.jsp");
            } else {
                // Caso haja erro, envia um erro 500
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir usuário.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Se ocorrer erro de SQL, envia um erro 500
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir usuário.");
        } catch (NumberFormatException e) {
            // Se houver erro ao converter o ID para número, envia um erro 400
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
