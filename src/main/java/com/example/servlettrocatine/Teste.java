package com.example.servlettrocatine;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.DAO.ComunidadeDAO;
import com.example.servlettrocatine.DAO.SenhaHash;
import com.example.servlettrocatine.model.Adm;
import com.example.servlettrocatine.model.Comunidade;

import java.security.NoSuchAlgorithmException;


public class Teste {
    public static void main(String[] args) {

        Comunidade adm = new Comunidade("Teste", "Teste", "teste", 2, "foto");
        ComunidadeDAO admDAO = new ComunidadeDAO();
        admDAO.inserirComunidade(adm);
    }
}
