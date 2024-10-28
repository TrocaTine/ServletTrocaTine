package com.example.servlettrocatine;

import com.example.servlettrocatine.DAO.TagDAO;
import com.example.servlettrocatine.model.Tag;


public class Teste {
    public static void main(String[] args) {
        TagDAO dao = new TagDAO();
        Tag tag = new Tag(6, "Menino", "Vermelho", "G", "Bom", 1);
        try{
            dao.inserirTag(tag);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
