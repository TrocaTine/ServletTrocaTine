package com.example.servlettrocatine.servlet.comunidade;

import com.example.servlettrocatine.DAO.ComunidadeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "listarTodasComunidades", value = "/listarComunidades")
public class listarTodasComunidades extends HttpServlet {
    public void doGet(HttpServlet Request, HttpServlet Response) throws IOException, ServletException {
        ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
    }

}
