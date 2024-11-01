package com.example.servlettrocatine.DAO;


import com.example.servlettrocatine.model.Conexao;
import com.example.servlettrocatine.model.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogDAO {
    Conexao conexao = new Conexao();

    public List<Log> listarLog() throws SQLException {
        String sql = "SELECT * FROM log";
        List<Log> logListagem = new ArrayList<>();
        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String operacao = rs.getString("operacao");
                String tabela = rs.getString("tabela");
                String data_hora = rs.getString("data_hora");
                String query = rs.getString("query");
                int idAdm = rs.getInt("idadm");
                Log log = new Log(id, operacao, tabela, data_hora, query, idAdm);
                logListagem.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logListagem;
    }

    public boolean inserirLog(Log log) {
        String sql = "INSERT INTO log (operacao, tabela, query, idadm) VALUES (?, ?, ?, ?)";
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, log.getOperacao());
            pstmt.setString(2, log.getTabela());
            pstmt.setString(3, log.getQuery());
            pstmt.setInt(4, log.getIdadm());

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }
}
