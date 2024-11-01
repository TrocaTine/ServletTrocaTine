package com.example.servlettrocatine.DAO;



import com.example.servlettrocatine.model.Adm;
import com.example.servlettrocatine.model.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdmDAO {

    Conexao conexao = new Conexao();

    // Insere um novo administrador no banco de dados.
    // Retorna true se a operação for bem-sucedida, caso contrário, false.
    public boolean inserirAdm(Adm adm) {
        String sql = "INSERT INTO adm (nome, email, senha, idusuario) VALUES (?, ?, ?, ?)";
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adm.getNome());
            pstmt.setString(2, adm.getEmail());
            pstmt.setString(3, adm.getSenha());
            pstmt.setInt(4, adm.getIdUsuario());

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    public int verificarAdmin(String user, String senha) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM Adm WHERE nome = ? AND senha = ?");
            conexao.pstmt.setString(1, user);
            conexao.pstmt.setString(2, senha);
            conexao.rs = conexao.pstmt.executeQuery();

            if (conexao.rs.next()) {
                return conexao.rs.getInt("id"); // Login correto
            } else {
                return -1; // Login incorreto
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }


    // Edita a senha de um administrador com base no ID.
    // Retorna true se a operação for bem-sucedida, caso contrário, false.
    public boolean editarAdmPorId(Adm adm) {
        String sql = "UPDATE adm SET nome = ?, email = ?, senha = ?, idusuario = ?  WHERE id = ?";
        Connection conn = conexao.conectar();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adm.getNome());
            pstmt.setString(2, adm.getEmail());
            pstmt.setString(3, adm.getSenha());
            pstmt.setInt(4, adm.getIdUsuario());
            pstmt.setInt(5, adm.getId());
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
        String sql = "SELECT * FROM adm WHERE id = ?";
        Connection conn = conexao.conectar();

        Adm adm = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idAdm);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                int idusuario = rs.getInt("idusuario");

                adm = new Adm(idAdm, nome, email, senha, idusuario);
            } else {
                System.out.println("Nenhum administrador encontrado com o ID: " + idAdm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar();
        }
        return adm;
    }

    // Exclui um administrador com base no ID do administrador.
    // Retorna true se a operação for bem-sucedida, caso contrário, false.
    public boolean excluirAdmPorId(int idAdm) {
        String sql = "DELETE FROM adm WHERE id = ?";
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

    public List<Adm> listarAdms() throws SQLException {
        String sql = "SELECT * FROM adm";
        List<Adm> admListagem = new ArrayList<>();
        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                int idUsuario = rs.getInt("idusuario");
                Adm adm = new Adm(id, nome, email, senha, idUsuario);
                admListagem.add(adm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admListagem;
    }
}
