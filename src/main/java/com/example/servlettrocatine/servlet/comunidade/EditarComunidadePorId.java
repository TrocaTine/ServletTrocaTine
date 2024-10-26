package com.example.servlettrocatine.servlet.comunidade;

import com.example.servlettrocatine.DAO.ComunidadeDAO;
import com.example.servlettrocatine.model.Comunidade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "editarComunidadePorID", value = "/editarComunidadePorID")
public class EditarComunidadePorId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        String idComunidade = request.getParameter("id");
        String nomeComunidade = request.getParameter("nome");
        String criadorComunidade = request.getParameter("criador");
        String descricaoComunidade = request.getParameter("descricao");
        String qntComunidade = request.getParameter("qnt_integrantes");
        String fotoComunidade = request.getParameter("foto_perfil");
        Comunidade comunidade = new Comunidade(Integer.parseInt(idComunidade), nomeComunidade, criadorComunidade, descricaoComunidade, Integer.parseInt(qntComunidade), Integer.parseInt(fotoComunidade));


        // Verifique se os parâmetros são válidos
        if (nomeComunidade == null || idComunidade == null || qntComunidade == null || fotoComunidade == null || descricaoComunidade == null || criadorComunidade == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
            return;
        }

        try {
            // Inserir categoria no banco de dados
            ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
            boolean certo = comunidadeDAO.editarComunidadePorId(comunidade);

            if (certo) {
                request.getSession().setAttribute("successMessage", "Comunidade editada com sucesso!");
                response.sendRedirect("jsp/categoria/editarComunidadePorId.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar comunidade!.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar comunidade.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
