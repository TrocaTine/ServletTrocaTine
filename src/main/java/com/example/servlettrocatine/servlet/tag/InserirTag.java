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

@WebServlet(name = "InserirTag", value = "/inserirTag") // Mapeia a URL "/inserirTag" para este servlet
public class InserirTag extends HttpServlet {

    // Método que lida com requisições POST para inserir uma nova tag
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar os parâmetros do formulário
        String genero = request.getParameter("genero");
        String cor = request.getParameter("cor");
        String tamanho = request.getParameter("tamanho");
        String qualidade = request.getParameter("qualidade");
        String idtipo_produto = request.getParameter("idtipo_produto");

        // Coletar o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Validar se todos os campos estão preenchidos
        if (genero == null || cor == null || tamanho == null || qualidade == null ||
                genero.isEmpty() || cor.isEmpty() || tamanho.isEmpty() || qualidade.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
            return;
        }

        try {
            // Criar a nova tag com os dados do formulário
            Tag novaTag = new Tag(genero, cor, tamanho, qualidade, Integer.parseInt(idtipo_produto)); // ID será gerado pelo banco

            // Inserir a nova tag no banco de dados
            TagDAO tagDAO = new TagDAO();
            boolean sucesso = tagDAO.inserirTag(novaTag);

            // Criar o log para registrar a inserção da nova tag
            Log log = new Log("Inserir", "Adm", "insert into tag (genero, cor, tamanho, qualidade, " +
                    "idtipo_produto) values ('" + genero + "', '" + cor + "', '" + tamanho + "', '" + qualidade +
                    "', " + idtipo_produto + ")", idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            // Se a inserção e o log forem bem-sucedidos, redireciona para a página de inserção de tags com sucesso
            if (sucesso && logCerto) {
                request.getSession().setAttribute("successMessage", "Tag adicionada com sucesso!");
                response.sendRedirect("jsp/tag/inserirTag.jsp");
            } else {
                // Caso contrário, envia um erro 500 (erro interno do servidor)
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir a tag.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Se ocorrer erro de SQL, envia um erro 500 (erro interno do servidor)
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir a tag.");
        }
    }
}
