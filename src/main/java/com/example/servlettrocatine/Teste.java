package com.example.servlettrocatine;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.DAO.TagDAO;
import com.example.servlettrocatine.DAO.UsuarioDAO;
import com.example.servlettrocatine.model.Log;
import com.example.servlettrocatine.model.Usuario;

import java.nio.file.Paths;
import java.sql.SQLException;


public class Teste {
    public static void main(String[] args) throws SQLException {
        Usuario usuario = new Usuario();

        System.out.println(usuario.getSobrenome());
    }
}
