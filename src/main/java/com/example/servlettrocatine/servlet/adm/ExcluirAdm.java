package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.model.Log;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet responsável por excluir um administrador.
 * Mapeada para a URL "/excluirAdm".
 */
@WebServlet(name = "ExcluirAdmPorID", value = "/excluirAdm")
public class ExcluirAdm extends HttpServlet {

    /**
     * Método doPost para processar a requisição POST.
     * Exclui um administrador e registra a operação no log.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Coleta o ID do administrador a ser excluído, enviado pelo formulário
        String idParam = request.getParameter("id");

        // Obtém o ID do administrador atual da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Valida se o ID do administrador a ser excluído foi fornecido
        if (idParam == null) {
            request.setAttribute("erro", "ID é obrigatório.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            return;
        }

        try {
            // Cria uma instância de AdmDAO para manipulação do banco de dados
            AdmDAO admDAO = new AdmDAO();

            // Executa a exclusão do administrador
            boolean certo = admDAO.excluirAdmPorId(Integer.parseInt(idParam));

            // Cria uma operação de log para registrar a exclusão
            Log log = new Log(
                    "Excluir",
                    "Adm",
                    "Administrador excluído com ID: " + idParam,
                    idAdm
            );

            // Cria uma instância de LogDAO e insere o log no banco de dados
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            // Verifica se a exclusão e o log foram realizados com sucesso
            if (certo && logCerto) {
                // Define uma mensagem de sucesso na sessão e redireciona para a página de exclusão
                request.getSession().setAttribute("successMessage", "Administrador excluído com sucesso!");
                response.sendRedirect("adms");
            } else {
                // Envia um erro de servidor se a exclusão falhar
                request.setAttribute("erro", "Erro ao excluir administrador.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Trata exceção de formato inválido para o ID
            request.setAttribute("erro", "ID inválido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
