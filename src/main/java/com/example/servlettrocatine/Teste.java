package com.example.servlettrocatine;

import com.example.servlettrocatine.DAO.ComunidadeDAO;
import com.example.servlettrocatine.model.Comunidade;

public class Teste {
    public static void main(String[] args) {
        ComunidadeDAO dao = new ComunidadeDAO();
        Comunidade comunidade = new Comunidade(
                1,
                "Java",
                "Daniel",
                "Um grupo de estudos de Java",
                2,
                1);
        try{
            dao.editarComunidadePorId(comunidade);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
