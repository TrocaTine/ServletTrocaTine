package com.example.servlettrocatine;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.DAO.SenhaHash;
import com.example.servlettrocatine.model.Adm;

import java.security.NoSuchAlgorithmException;


public class Teste {
    public static void main(String[] args) {
        String senha = "admin123";
        SenhaHash cripto;
        try {
            cripto = new SenhaHash(senha);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        Adm adm = new Adm("admin", "a@gmail.com", cripto.getSenha(), 1);
        AdmDAO admDAO = new AdmDAO();
        admDAO.inserirAdm(adm);
    }
}
