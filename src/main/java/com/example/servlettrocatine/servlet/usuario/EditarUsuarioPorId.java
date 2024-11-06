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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "EditarUsuarioPorId", value = "/editarUsuarioPorId")
public class EditarUsuarioPorId extends HttpServlet {

    // Expressões regulares para validação
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";  // Email no formato nome@gmail.com
    private static final String TELEFONE_REGEX = "^[0-9]{2}\\s?[0-9]{5}\\s?[0-9]{4}$"; // Telefone em vários formatos
    private static final String CPF_REGEX = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$"; // CPF no formato xxx.xxx.xxx-xx

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
                // Caso ocorra algum erro ao editar o usuário, retornar erro 404
                request.setAttribute("erro", "Erro: 404 - Falha ao editar o usuário.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // Caso ocorra algum erro no banco de dados, retornar erro 500
            e.printStackTrace();

            request.setAttribute("erro", "Erro: 500 - Falha ao acessar o banco de dados.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Caso ocorra erro ao converter os IDs para inteiro, retornar erro 400

            request.setAttribute("erro", "Erro: 400 - Id inválido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
