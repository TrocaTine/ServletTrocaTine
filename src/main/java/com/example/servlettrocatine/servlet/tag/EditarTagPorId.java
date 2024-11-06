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
        String idcategoria = request.getParameter("idcategoria");

        // Coletar o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Validar se todos os parâmetros necessários estão presentes
        if (idParam == null || idParam.isEmpty() || genero == null || cor == null || tamanho == null || qualidade == null) {
            request.setAttribute("erro", "Erro: 404 - Todos os campos devem ser preenchidos.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            return;
        }

        try {
            // Converter o ID para inteiro
            int id = Integer.parseInt(idParam);

            // Criar um novo objeto Tag com os dados atualizados
            Tag novaTag = new Tag(id, genero, cor, tamanho, qualidade, Integer.parseInt(idcategoria));

            // Atualizar a tag no banco de dados
            TagDAO tagDAO = new TagDAO();
            boolean sucesso = tagDAO.editarTagPorId(id, novaTag);

            // Criar o log para registrar a atualização
            Log log = new Log(
                    "Editar",
                    "Tag",
                    "Atualização de tag com ID" + id + " realizada", idAdm);
            // Criação do objeto logDAO
            LogDAO logDAO = new LogDAO();

            // Inserção do log no banco de dados
            boolean logCerto = logDAO.inserirLog(log);

            // Se a atualização e o log foram bem-sucedidos, redireciona para a página de sucesso
            if (sucesso && logCerto) {
                request.getSession().setAttribute("successMessage", "Tag atualizada com sucesso!");
                response.sendRedirect("jsp/tag/editarTagPorId.jsp");
            } else {
                // Caso contrário, envia um erro 404 (erro de inserção)
                request.setAttribute("erro", "Erro: 404 - Falha ao atualizar a tag.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Se ocorrer erro de SQL, envia um erro 500 (erro interno do servidor)
            request.setAttribute("erro", "Erro: 500 - Falha ao acessar o banco de dados.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Se o ID ou o ID do tipo de produto não puderem ser convertidos para inteiro, envia um erro 400 (Bad Request)
            request.setAttribute("erro", "Erro: 400 - Id inválido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
