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
 * Servlet responsável por inserir um novo administrador.
 * Mapeada para a URL "/inserirAdm".
 */
@WebServlet(name = "InserirAdm", value = "/inserirAdm")
public class InserirAdm extends HttpServlet {

    /**
     * Método doPost para processar a requisição POST.
     * Insere um administrador e registra a operação no log.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Coleta os dados do formulário enviados pelo usuário
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String idUsuario = request.getParameter("idUsuario");

            // Obtém o ID do administrador atual da sessão
            int idAdm = (Integer) request.getSession().getAttribute("idAdm");

            // Verifica se os parâmetros obrigatórios foram preenchidos
            if (nome == null || email == null || senha == null || idUsuario == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
                return;
            }

            try {
                // Cria uma instância de AdmDAO para manipulação do banco de dados
                AdmDAO admDAO = new AdmDAO();

                // Cria um objeto Adm com os dados coletados
                Adm adm = new Adm(nome, email, senha, Integer.parseInt(idUsuario));

                // Insere o administrador no banco de dados
                boolean certo = admDAO.inserirAdm(adm);

                // Cria uma operação de log para registrar a inserção
                Log log = new Log(
                        "Inserir",
                        "Adm",
                        "insert into Adm (nome, email, senha, idUsuario) values ('" + nome + "', '" + email + "', '" + senha + "', '" + idUsuario + "')",
                        idAdm
                );

                // Insere o log no banco de dados
                LogDAO logDAO = new LogDAO();
                boolean logCerto = logDAO.inserirLog(log);

                // Verifica se a inserção e o log foram realizados com sucesso
                if (certo && logCerto) {
                    // Define uma mensagem de sucesso na sessão e redireciona para a página de sucesso
                    request.getSession().setAttribute("successMessage", "Administrador adicionado com sucesso!");
                    response.sendRedirect("jsp/adm/adicionarAdm.jsp");
                } else {
                    // Envia um erro de servidor se a inserção falhar
                    request.setAttribute("erro", "Erro ao inserir administrador.");
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir administrador.");
                }
            } catch (Exception e) {
                // Trata exceções gerais e redireciona para uma página de erro
                request.setAttribute("erro", e.getMessage());
                request.getRequestDispatcher("../erro400.jsp").forward(request, response);
            }
        } catch (InternalError e) {
            // Trata erros internos e redireciona para uma página de erro
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("../erro400.jsp").forward(request, response);
        }
    }
}
