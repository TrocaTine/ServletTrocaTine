package com.example.servlettrocatine;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.DAO.ComunidadeDAO;
import com.example.servlettrocatine.DAO.SenhaHash;
import com.example.servlettrocatine.model.Adm;
import com.example.servlettrocatine.model.Comunidade;

import java.security.NoSuchAlgorithmException;


public class Teste {
    public static void main(String[] args) {
        AdmDAO admDAO = new AdmDAO();
        try {
            SenhaHash senhaHash = new SenhaHash("senha123");
            System.out.println(senhaHash.getSenha());
            } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
        }
    }
}
