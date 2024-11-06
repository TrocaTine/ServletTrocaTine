package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.model.Adm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet responsável por buscar um administrador pelo ID.
 * Mapeada com a URL "/buscarAdm".
 */
@WebServlet(name = "buscarAdmPorID", value = "/buscarAdm")
public class BuscarAdm extends HttpServlet {

    /**
     * Método doGet para processar a requisição GET.
     * Busca um administrador pelo ID fornecido na URL e encaminha para uma página JSP.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtém o ID do administrador a partir dos parâmetros da requisição
        String idComunidade = request.getParameter("id");

        // Verifica se o ID foi fornecido
        if (idComunidade == null || idComunidade.isEmpty()) {
            request.setAttribute("erro", "ID não fornecido.");
            request.getRequestDispatcher("../erro400.jsp").forward(request, response);
            return;
        }

        int id;
        try {
            // Tenta converter o ID para um número inteiro
            id = Integer.parseInt(idComunidade);
        } catch (NumberFormatException e) {
            // Trata erro de conversão caso o ID não seja um número válido
            request.setAttribute("erro", "ID inválido: " + e.getMessage());
            request.getRequestDispatcher("../erro400.jsp").forward(request, response);
            return;
        }

        // Cria uma instância de AdmDAO para realizar a consulta no banco de dados
        AdmDAO admDAO = new AdmDAO();

        // Busca o administrador pelo ID fornecido
        Adm adm = admDAO.buscarAdmPorId(id);

        // Verifica se o administrador foi encontrado
        if (adm == null) {
            request.setAttribute("erro", "Administrador não encontrado.");
            request.getRequestDispatcher("../erro400.jsp").forward(request, response);
            return;
        }

        // Define o administrador encontrado como atributo da requisição
        request.setAttribute("adm", adm);

        // Encaminha para a página JSP que exibirá os dados do administrador
        request.getRequestDispatcher("jsp/adm/buscarAdm.jsp").forward(request, response);
    }
}
