package com.example.servlettrocatine.servlet.usuario;

import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.DAO.UsuarioDAO;
import com.example.servlettrocatine.model.Log;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ExcluirUsuarioPorId", value = "/excluirUsuarioPorId")
public class ExcluirUsuarioPorId extends HttpServlet {

    // Método que lida com a requisição POST para excluir um usuário pelo ID
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Coletar o ID do usuário a ser excluído
        String idParam = request.getParameter("id");

        // Recuperar o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verificar se o parâmetro ID foi fornecido
        if (idParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID é obrigatório.");
            return;
        }

        try {
            // Criar uma instância do DAO para excluir o usuário
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean certo = usuarioDAO.excluirUsuarioPorId(Integer.parseInt(idParam));

            // Criar o log para registrar a ação de exclusão
            Log log = new Log(
                    "Excluir",
                    "Usuario",
                    "Usuário com ID: " + idParam + " excluído", idAdm);
            LogDAO logDAO = new LogDAO();
            boolean logCerto = logDAO.inserirLog(log);

            // Se a exclusão e o log forem bem-sucedidos, redirecionar para a página de exclusão com sucesso
            if (certo && logCerto) {
                request.getSession().setAttribute("successMessage", "Usuário excluído com sucesso!");
                response.sendRedirect("jsp/usuario/excluirUsuarioPorId.jsp");
            } else {
                // Caso ocorra algum erro ao excluir o usuário, retornar erro 404
                request.setAttribute("erro", "Erro: 404 - Falha ao excluir usuário.");
                request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // Caso ocorra algum erro no banco de dados, retornar erro 500
            e.printStackTrace();

            request.setAttribute("erro", "Erro: 500 - Falha ao acessar o banco de dados.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Caso ocorra erro ao converter o ID para inteiro, retornar erro 400
            request.setAttribute("erro", "Erro: 400 - ID inválido.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }
}
