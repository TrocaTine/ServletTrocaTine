package com.example.servlettrocatine.servlet.comunidade;

import com.example.servlettrocatine.DAO.ComunidadeDAO;
import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.model.Comunidade;
import com.example.servlettrocatine.model.Log;
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
        String qntComunidade = request.getParameter("qntIntegrantes"); // Nome ajustado
        String fotoComunidade = request.getParameter("fotoPerfil"); // Nome ajustado

        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifique se os parâmetros são válidos
        if (idComunidade == null || nomeComunidade == null || criadorComunidade == null ||
                descricaoComunidade == null || qntComunidade == null || fotoComunidade == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
            return;
        }

        try {
            // Criar objeto Comunidade
            Comunidade comunidade = new Comunidade(
                    Integer.parseInt(idComunidade),
                    nomeComunidade,
                    criadorComunidade,
                    descricaoComunidade,
                    Integer.parseInt(qntComunidade),
                    fotoComunidade
            );

            // Atualizar comunidade no banco de dados
            ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
            boolean certo = comunidadeDAO.editarComunidadePorId(comunidade);

            Log log = new Log("Editar", "Comunidade", "update comunidade set nome = "+ nomeComunidade +", criador = "+ criadorComunidade +", descricao = "+
                    descricaoComunidade +", qnt_integrantes = "+ qntComunidade +", foto_perfil = "+ fotoComunidade +" where id = "+  idComunidade, idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            if (certo && logCerto) {
                request.getSession().setAttribute("successMessage", "Comunidade editada com sucesso!");
                response.sendRedirect(request.getContextPath() + "/comunidade");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar comunidade.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro SQL exception ao editar comunidade.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID ou valores numéricos inválidos.");
        }
    }
}
