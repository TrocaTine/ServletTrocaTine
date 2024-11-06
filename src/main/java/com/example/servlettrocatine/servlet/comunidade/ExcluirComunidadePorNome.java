package com.example.servlettrocatine.servlet.comunidade;

import com.example.servlettrocatine.DAO.ComunidadeDAO;
import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.model.Log;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "excluirComunidadePorNome", value = "/excluirComunidadePorNome") // Mapeia a URL para este servlet
public class ExcluirComunidadePorNome extends HttpServlet {

    // Método que lida com requisições POST para excluir uma comunidade pelo nome
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Coleta o parâmetro "nome" da requisição
        String nomeComunidade = request.getParameter("nome");

        // Obtém o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifica se o parâmetro "nome" foi fornecido
        if (nomeComunidade == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome é obrigatório.");
            return;
        }

        try {
            // Tenta excluir a comunidade pelo nome no banco de dados
            ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
            boolean certo = comunidadeDAO.excluirComunidadePorNome(nomeComunidade);

            // Cria o log de exclusão
            Log log = new Log(
                    "Excluir",
                    "Comunidade",
                    "Comunidade com o nome: " + nomeComunidade + " excluída", idAdm);

            // Cria o objeto LogDAO  no banco de dados
            LogDAO logDAO = new LogDAO();

            // Insere o log no banco de dados
            boolean logCerto = logDAO.inserirLog(log);

            // Verifica se tanto a exclusão quanto a inserção do log foram bem-sucedidas
            if (certo && logCerto) {
                // Define a mensagem de sucesso na sessão e redireciona para a página de sucesso
                request.getSession().setAttribute("successMessage", "Comunidade excluída com sucesso!");
                response.sendRedirect("jsp/comunidade/ComunidadeExcluidaComSucesso.jsp");
            } else {
                request.setAttribute("erro", "Erro: 404 - Falha ao excluir comunidade.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Retorna erro em caso de problemas com o banco de dados
            request.setAttribute("erro", "Erro: 500 - Falha na conexão com o banco de dados.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Retorna erro se o ID fornecido não for válido
            request.setAttribute("erro", "Erro: 400 - Id inválido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
