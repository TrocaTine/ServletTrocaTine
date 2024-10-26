package com.example.servlettrocatine.servlet.comunidade;

import com.example.servlettrocatine.DAO.ComunidadeDAO;
import com.example.servlettrocatine.Model.Comunidade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "inserirComunidade", value = "/inserirComunidade")
@MultipartConfig(maxFileSize = 16177215)
public class inserirComunidade extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String criador = request.getParameter("criador");
        String descricao = request.getParameter("descricao");
        int qntIntegrantes = Integer.parseInt(request.getParameter("qntIntegrantes"));
        Comunidade comunidade = new Comunidade(id, nome, criador, descricao, qntIntegrantes, 2);

        comunidadeDAO.inserirComunidade(comunidade);

    }
}
