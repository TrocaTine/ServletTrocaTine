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

@WebServlet(name = "excluirComunidadePorID", value = "/excluirComunidadePorID") // Mapeia a URL para este servlet
public class ExcluirComunidadePorId extends HttpServlet {

    // Método que lida com requisições POST para excluir uma comunidade
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Coleta o parâmetro "id" da requisição
        String idComunidade = request.getParameter("id");

        // Obtém o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifica se o parâmetro "id" foi fornecido
        if (idComunidade == null) {
            request.setAttribute("erro", "Erro: 404 - Id inválido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            return;
        }

        try {
            // Tenta excluir a comunidade no banco de dados
            ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
            boolean certo = comunidadeDAO.excluirComunidadePorId(Integer.parseInt(idComunidade));

            // Cria o log de exclusão
            Log log = new Log(
                    "Excluir",
                    "Comunidade",
                    "Comunidade com ID:" + idComunidade + " excluída", idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            // Verifica se tanto a exclusão quanto a inserção do log foram bem-sucedidas
            if (certo && logCerto) {
                // Define a mensagem de sucesso na sessão e redireciona para a página de sucesso
                request.getSession().setAttribute("successMessage", "Comunidade excluída com sucesso!");
                response.sendRedirect("comunidade");
            } else {
                request.setAttribute("erro", "Erro: 404 - Falha ao excluir comunidade.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Retorna erro em caso de problemas com o banco de dados
            request.setAttribute("erro", "Erro: 500 - Falha ao acessar o banco de dados.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Retorna erro se o ID fornecido não for válido
            request.setAttribute("erro", "Erro: 400 - Id inválido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
