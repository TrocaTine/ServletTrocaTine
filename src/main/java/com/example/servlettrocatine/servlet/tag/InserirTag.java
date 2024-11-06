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
        String idcategoria = request.getParameter("idcategoria");

        // Coletar o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Validar se todos os campos estão preenchidos
        if (genero == null || cor == null || tamanho == null || qualidade == null ||
                genero.isEmpty() || cor.isEmpty() || tamanho.isEmpty() || qualidade.isEmpty()) {
            request.setAttribute("erro", "Erro: 400 - Todos os campos devem ser preenchidos.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            return;
        }

        try {
            // Criar a nova tag com os dados do formulário
            Tag novaTag = new Tag(genero, cor, tamanho, qualidade, Integer.parseInt(idcategoria)); // ID será gerado pelo banco

            // Inserir a nova tag no banco de dados
            TagDAO tagDAO = new TagDAO();
            boolean sucesso = tagDAO.inserirTag(novaTag);

            // Criar o log para registrar a inserção da nova tag
            Log log = new Log(
                    "Inserir",
                    "Tag",
                    "Nova tag inserida: "+genero+" "+cor+" "+tamanho+" "+qualidade, idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            // Se a inserção e o log forem bem-sucedidos, redireciona para a página de inserção de tags com sucesso
            if (sucesso && logCerto) {
                request.getSession().setAttribute("successMessage", "Tag adicionada com sucesso!");
                response.sendRedirect("jsp/tag/inserirTag.jsp");
            } else {
                // Caso contrário, envia um erro 404 (erro ao inserir)
                request.setAttribute("erro", "Erro: 404 - Falha ao inserir a tag no banco de dados.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Se ocorrer erro de SQL, envia um erro 500 (erro interno do servidor)
            request.setAttribute("erro", "Erro: 500 - Falha ao acessar o banco de dados.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
