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
    // Instância da classe Conexao para gerenciar a conexão com o banco de dados
    Conexao conexao = new Conexao();

    // Método para listar todos os registros de log do banco de dados
    public List<Log> listarLog() throws SQLException {
        String sql = "SELECT * FROM log";
        List<Log> logListagem = new ArrayList<>();

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Executa a consulta para listar logs
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // Recupera os dados de cada registro de log
                int id = rs.getInt("id");
                String operacao = rs.getString("tipo_operacao");
                String tabela = rs.getString("tabela");
                String data_hora = rs.getString("data_hora");
                String query = rs.getString("query");
                int idAdm = rs.getInt("idadm");

                // Cria um objeto Log com os dados recuperados e adiciona à lista
                Log log = new Log(id, operacao, tabela, data_hora, query, idAdm);
                logListagem.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return logListagem; // Retorna a lista de logs
    }

    // Método para inserir um novo registro de log no banco de dados
    public boolean inserirLog(Log log) {
        String sql = "INSERT INTO log (tipo_operacao, tabela, query, idadm) VALUES (?, ?, ?, ?)";
        Connection conn = conexao.conectar();

        try {
            // Prepara a instrução SQL para inserir o log
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, log.getOperacao());
            pstmt.setString(2, log.getTabela());
            pstmt.setString(3, log.getQuery());
            pstmt.setInt(4, log.getIdadm());

            // Executa a inserção
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // Desconecta do banco de dados
            conexao.desconectar();
        }
    }
}
