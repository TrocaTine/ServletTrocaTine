package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet responsável por listar todos os administradores.
 * Mapeada para a URL "/adms".
 */
@WebServlet(name = "ListarAdms", value = "/adms")
public class ListarAdmins extends HttpServlet {

    /**
     * Método doPost para processar a requisição POST.
     * Lista todos os administradores e encaminha a resposta para a página de listagem.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Cria uma instância de AdmDAO para acessar o banco de dados
        AdmDAO admDAO = new AdmDAO();


        try {
            // Atribui a lista de administradores ao atributo "adms" para ser exibida na JSP
            request.setAttribute("adms", admDAO.listarAdms());

            // Encaminha a requisição para a página de listagem de administradores
            request.getRequestDispatcher("jsp/adm/listarAdm.jsp").forward(request, response);
        } catch (Exception e) {
            // Imprime o erro no console para depuração
            e.printStackTrace();

            // Envia uma resposta de erro ao cliente em caso de falha
            request.setAttribute("erro", "Erro ao listar administradores.");
            request.getRequestDispatcher("jsp/erro.jsp").forward(request, response);
        }
    }

    /**
     * Método doGet que redireciona para o método doPost.
     * Permite que a listagem seja acessada tanto por requisições GET quanto POST.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
