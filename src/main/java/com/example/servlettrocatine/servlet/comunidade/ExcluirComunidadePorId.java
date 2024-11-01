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

@WebServlet(name = "excluirComunidadePorID", value = "/excluirComunidadePorID")
public class ExcluirComunidadePorId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idComunidade = request.getParameter("id");

        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        if (idComunidade == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID é obrigatório.");
            return;
        }
        try {
            ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
            boolean certo = comunidadeDAO.excluirComunidadePorId(Integer.parseInt(idComunidade));
            Log log = new Log("Excluir", "Comunidade", "delete from comunidade  where id = "+  idComunidade, idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            if (certo && logCerto) {
                request.getSession().setAttribute("successMessage", "Comunidade excluida com sucesso!");
                response.sendRedirect("jsp/comunidade/excluirComunidadePorID.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir comunidade!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir comunidade!");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }

}
