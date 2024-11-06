package com.example.servlettrocatine.servlet.tag;

import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.DAO.TagDAO;
import com.example.servlettrocatine.model.Log;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ExcluirTagPorId", value = "/excluirTag") // Mapeia a URL "/excluirTag" para este servlet
public class ExcluirTagPorId extends HttpServlet {

    // Método que lida com requisições POST para excluir uma tag por ID
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar o parâmetro ID da requisição
        String idParam = request.getParameter("id");

        // Coletar o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Validar se o parâmetro ID está presente e não é vazio
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID é obrigatório para excluir a tag.");
            return;
        }

        try {
            // Converter o ID para inteiro
            int id = Integer.parseInt(idParam);

            // Excluir a tag no banco de dados
            TagDAO tagDAO = new TagDAO();
            boolean sucesso = tagDAO.excluirTagPorId(id);

            // Criar o log para registrar a exclusão
            Log log = new Log(
                    "Excluir",
                    "Tag",
                    "Tag " + idParam + " Excluída", idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            // Se a exclusão e o log foram bem-sucedidos, redireciona para a lista de tags
            if (sucesso && logCerto) {
                request.getSession().setAttribute("successMessage", "Tag excluída com sucesso!");
                response.sendRedirect("tags");
            } else {
                // Caso contrário, envia um erro 500 (erro interno do servidor)
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir a tag.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Se ocorrer erro de SQL, envia um erro 500 (erro interno do servidor)
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir a tag.");
        } catch (NumberFormatException e) {
            // Se o ID não puder ser convertido para inteiro, envia um erro 400 (Bad Request)
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
