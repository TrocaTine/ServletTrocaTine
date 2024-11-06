package com.example.servlettrocatine.model;

import io.github.cdimascio.dotenv.Dotenv; // Importa biblioteca para carregar variáveis de ambiente

import java.sql.*; // Importa pacotes necessários para manipulação de banco de dados

public class Conexao {
    public Connection conn; // Conexão com o banco de dados
    public PreparedStatement pstmt; // Prepara instruções SQL a serem executadas
    public ResultSet rs; // Armazena os resultados da consulta SQL

    // Método para conectar ao banco de dados
    public Connection conectar() {
        try {
            // Recupera as informações de conexão do banco de dados de variáveis de ambiente
            String url = System.getenv("DB_URL"); // URL de conexão com o banco
            String user = System.getenv("DB_USER"); // Usuário do banco de dados
            String password = System.getenv("DB_PASSWORD"); // Senha do banco de dados
            String driver = System.getenv("DB_DRIVER"); // Driver JDBC do banco

            // Registra o driver JDBC na aplicação
            Class.forName(driver);

            // Estabelece a conexão com o banco de dados
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace(); // Trata exceções de classe não encontrada
            return null; // Retorna null caso falhe ao encontrar a classe
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Trata exceções de SQL
            return null; // Retorna null caso falhe na conexão
        }
        return conn; // Retorna a conexão estabelecida
    }

    // Método para desconectar do banco de dados
    public void desconectar() {
        try {
            // Verifica se a conexão ainda está aberta antes de fechá-la
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Fecha a conexão com o banco
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Trata exceções durante o fechamento da conexão
        }
    }
}
