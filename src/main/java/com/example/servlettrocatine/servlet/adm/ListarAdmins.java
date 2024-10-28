package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ListarAdms", value = "/adms")
public class ListarAdmins extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdmDAO admDAO = new AdmDAO();

        try {
            // Lista as categorias e as armazena no atributo da requisição
            request.setAttribute("adms", admDAO.listarAdms());

            // Redireciona para uma página JSP para exibir as categorias
            request.getRequestDispatcher("jsp/adm/listarAdm.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Você pode redirecionar para uma página de erro, se desejar
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar categorias.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chama o método doPost para lidar com a requisição
        doPost(request, response);
    }
}