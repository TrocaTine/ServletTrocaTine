package com.example.servlettrocatine.DAO;



import com.example.servlettrocatine.Model.Adm;
import com.example.servlettrocatine.Model.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmDAO {

    Conexao conexao = new Conexao();

    // Insere um novo administrador no banco de dados.
    // Retorna true se a operação for bem-sucedida, caso contrário, false.
    public boolean inserirAdm(Adm adm) {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adm.getNome());
            pstmt.setString(2, adm.getEmail());
            pstmt.setString(3, adm.getSenha());

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    public boolean verificarAdmin(String user, String senha) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM Adm WHERE nome = ? AND senha = ?");
            conexao.pstmt.setString(1, user);
            conexao.pstmt.setString(2, senha);
            conexao.rs = conexao.pstmt.executeQuery();

            if (conexao.rs.next()) {
                return true; // Login correto
            } else {
                return false; // Login incorreto
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }
    // Edita a senha de um administrador com base no ID.
    // Retorna true se a operação for bem-sucedida, caso contrário, false.
    public boolean editarSenhaPorId(Adm adm) {
        String sql = "UPDATE usuarios SET senha = ? WHERE idusuario = ?";
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adm.getSenha());
            pstmt.setInt(2, adm.getId()); // Usar getId() de Adm

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    // Busca e exibe os dados de um administrador com base no ID do administrador.
    public Adm buscarAdmPorId(int idAdm) {
        String sql = "SELECT * FROM usuarios WHERE idusuario = ?";
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idAdm);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                int idusuario = rs.getInt("idusuario");

                System.out.println("Nome: " + nome);
                System.out.println("Email: " + email);
                System.out.println("Senha: " + senha);
                System.out.println("ID do Usuário: " + idusuario);

            } else {
                System.out.println("Nenhum administrador encontrado com o ID: " + idAdm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar();
        }
        return null;
    }

    // Exclui um administrador com base no ID do administrador.
    // Retorna true se a operação for bem-sucedida, caso contrário, false.
    public boolean excluirAdmPorId(int idAdm) {
        String sql = "DELETE FROM usuarios WHERE idusuario = ?";
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idAdm);

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
