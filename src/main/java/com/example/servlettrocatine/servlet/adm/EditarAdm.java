package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.model.Adm;
import com.example.servlettrocatine.model.Log;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet responsável por editar informações de um administrador.
 * Mapeada para a URL "/editarAdm".
 */
@WebServlet(name = "EditarPorID", value = "/editarAdm")
public class EditarAdm extends HttpServlet {

    /**
     * Método doPost para processar a requisição POST.
     * Atualiza informações de um administrador e registra a operação no log.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Coleta os dados do formulário enviados na requisição
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String idParam = request.getParameter("id");
        String idUsuario = request.getParameter("idUsuario");

        // Obtém o ID do administrador atual a partir da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Valida se todos os campos obrigatórios foram preenchidos
        if (nome == null || idParam == null || email == null || senha == null || idUsuario == null) {
            request.setAttribute("erro", "Todos os campos são obrigatórios.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            return;
        }

        try {
            // Cria uma instância de AdmDAO para manipulação do banco de dados
            AdmDAO admDAO = new AdmDAO();

            // Cria um objeto Adm com os dados recebidos
            Adm adm = new Adm(Integer.parseInt(idParam), nome, email, senha, Integer.parseInt(idUsuario));

            // Chama o método para editar o administrador no banco de dados
            boolean certo = admDAO.editarAdmPorId(adm);

            // Cria uma operação de log para registrar a atualização
            Log log = new Log(
                    "Editar",
                    "Adm",
                    "Administrador editado: Novo nome: " + nome + ", Novo email: " + email + ",Nova senha: " + senha +
                            ", Novo usuario relacionado: " + idUsuario + " Id do Administrador: " + idParam,
                    idAdm
            );

            // Cria uma instância de LogDAO e insere o log no banco de dados
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            // Verifica se a atualização e o log foram realizados com sucesso
            if (certo && logCerto) {
                // Define uma mensagem de sucesso na sessão e redireciona para a página de edição
                request.getSession().setAttribute("successMessage", "Administrador editado com sucesso!");
                response.sendRedirect("jsp/adm/editarAdm.jsp");
            } else {
                // Envia um erro de servidor se a edição falhar
                request.setAttribute("erro", "Erro ao editar administrador.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            // Trata exceção de formato inválido para o ID
            request.setAttribute("erro", "ID inválido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
