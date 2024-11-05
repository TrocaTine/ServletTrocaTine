package com.example.servlettrocatine;

import com.example.servlettrocatine.DAO.AdmDAO;
import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.model.Log;

import java.nio.file.Paths;
import java.sql.SQLException;


public class Teste {
    public static void main(String[] args) throws SQLException {
        LogDAO logDAO = new LogDAO();
        System.out.println(logDAO.listarLog());
    }
}
