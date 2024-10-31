package com.example.servlettrocatine.model;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Conexao {
    public Connection conn;
    public PreparedStatement pstmt;
    public ResultSet rs;

    // Método para conectar ao banco de dados
    public Connection conectar() {
        try {
            // Obtendo os valores das variáveis de ambiente
            Dotenv dotenv = Dotenv.configure().directory("C:\\dev\\ServletTrocaTine\\.env").load();

            // Obtendo as variáveis de ambiente do arquivo .env
            String driver = dotenv.get("DB_DRIVER");
            String url = dotenv.get("DB_URL");
            String user = dotenv.get("DB_USER");
            String password = dotenv.get("DB_PASSWORD");

            // Informando qual driver de conexão será utilizado pelo DriverManager
            Class.forName(driver);

            // Criando a conexão
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            return null;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
        return conn;
    }

    // Método para desconectar do banco
    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                // Desconectando do banco
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}

