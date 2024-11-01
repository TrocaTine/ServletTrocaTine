package com.example.servlettrocatine.servlet.adm;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.model.Adm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "buscarAdmPorID", value = "/buscarAdm")
public class BuscarAdm extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idComunidade = request.getParameter("id");
        if (idComunidade == null || idComunidade.isEmpty()) {
            request.setAttribute("erro", "ID não fornecido.");
            request.getRequestDispatcher("../erro400.jsp").forward(request, response);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idComunidade);
        } catch (NumberFormatException e) {
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("../erro400.jsp").forward(request, response);
            return;
        }

        AdmDAO AdmDAO = new AdmDAO();
        Adm adm = AdmDAO.buscarAdmPorId(id);
        if (adm == null) {
            request.setAttribute("erro", "Administrador não encontrada.");
            request.getRequestDispatcher("../erro400.jsp").forward(request, response);
            return;
        }
        request.setAttribute("adm", adm);
        request.getRequestDispatcher("jsp/adm/buscarAdm.jsp").forward(request, response);
    }
}
