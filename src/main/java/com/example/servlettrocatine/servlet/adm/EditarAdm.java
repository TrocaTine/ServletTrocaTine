package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.model.Adm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EditarPorID", value = "/editarAdm")
public class EditarAdm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletar dados do formulário
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String idParam = request.getParameter("id");
        String idUsuario = request.getParameter("idUsuario");

        // Verifique se os parâmetros são válidos
        if (nome == null || idParam == null || email == null || senha == null || idUsuario == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
            return;
        }

        try {
            // Inserir categoria no banco de dados
            AdmDAO admDAO = new AdmDAO();
            Adm adm = new Adm(Integer.parseInt(idParam), nome, email, senha, Integer.parseInt(idUsuario));
            boolean certo = admDAO.editarAdmPorId(adm);

            if (certo) {
                request.getSession().setAttribute("successMessage", "Categoria editada com sucesso!");
                response.sendRedirect("jsp/adm/editarAdm.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar categoria.");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }
}
