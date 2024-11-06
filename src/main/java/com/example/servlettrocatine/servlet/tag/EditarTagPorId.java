package com.example.servlettrocatine.servlet.tag;

import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.DAO.TagDAO;
import com.example.servlettrocatine.model.Log;
import com.example.servlettrocatine.model.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditarTagPorId", value = "/editarTagPorId") // Mapeia a URL "/editarTagPorId" para este servlet
public class EditarTagPorId extends HttpServlet {

    // Método que lida com requisições POST para editar uma tag por ID
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar os parâmetros do formulário
        String idParam = request.getParameter("id");
        String genero = request.getParameter("genero");
        String cor = request.getParameter("cor");
        String tamanho = request.getParameter("tamanho");
        String qualidade = request.getParameter("qualidade");
        String idtipo_produto = request.getParameter("idtipo_produto");

        // Coletar o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Validar se todos os parâmetros necessários estão presentes
        if (idParam == null || idParam.isEmpty() || genero == null || cor == null || tamanho == null || qualidade == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
            return;
        }

        try {
            // Converter o ID para inteiro
            int id = Integer.parseInt(idParam);

            // Criar um novo objeto Tag com os dados atualizados
            Tag novaTag = new Tag(id, genero, cor, tamanho, qualidade, Integer.parseInt(idtipo_produto));

            // Atualizar a tag no banco de dados
            TagDAO tagDAO = new TagDAO();
            boolean sucesso = tagDAO.editarTagPorId(id, novaTag);

            // Criar o log para registrar a atualização
            Log log = new Log("Editar", "Tag", "Atualização de tag com ID" + id + " realizada", idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            // Se a atualização e o log foram bem-sucedidos, redireciona para a página de sucesso
            if (sucesso && logCerto) {
                request.getSession().setAttribute("successMessage", "Tag atualizada com sucesso!");
                response.sendRedirect("jsp/tag/editarTag.jsp");
            } else {
                // Caso contrário, envia um erro 500 (erro interno do servidor)
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao atualizar a tag.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Se ocorrer erro de SQL, envia um erro 500 (erro interno do servidor)
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao atualizar a tag.");
        } catch (NumberFormatException e) {
            // Se o ID ou o ID do tipo de produto não puderem ser convertidos para inteiro, envia um erro 400 (Bad Request)
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
