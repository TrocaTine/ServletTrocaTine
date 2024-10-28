package com.example.servlettrocatine.DAO;


import com.example.servlettrocatine.model.Categoria;
import com.example.servlettrocatine.model.Conexao;
import com.example.servlettrocatine.model.Endereco;
import com.example.servlettrocatine.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Conexao conexao = new Conexao();
   // Método para inserir um novo usuário no banco de dados
   public boolean inserirUsuario(Usuario usuario) throws SQLException {
       String sql = "INSERT INTO usuario (id, nome, telefone, senha, trocadinhas, email, cpf, dt_nascimento, " +
               "foto_perfil, idendereco) VALUES (?,?,?,?,?,?,?,?,?,?)";
       try (Connection conn = conexao.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

           pstmt.setInt(1, usuario.getId()); // id como String
           pstmt.setString(2, usuario.getNome()); // nome
           pstmt.setString(3, usuario.getTelefone()); // telefone
           pstmt.setString(4, usuario.getSenha()); // senha
           pstmt.setInt(5, 10);
           pstmt.setString(6, usuario.getEmail()); // email
           pstmt.setString(7, usuario.getCpf()); // cpf
           pstmt.setDate(8, java.sql.Date.valueOf(usuario.getDtNascimento())); // dt_nascimento como String
           pstmt.setNull(9, java.sql.Types.VARCHAR); // foto_perfil como nulo
           pstmt.setNull(10, 0); // idendereco como nulo

           pstmt.executeUpdate();
           return true;
       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       } finally {
           conexao.desconectar();
       }
   }

    // Método para inserir um endereço e retornar o ID gerado
    public int inserirEnderecoRetornaId(Endereco endereco) throws SQLException {
        String sql = "INSERT INTO endereco (cidade, rua, cep, complemento, numero, estado) VALUES (?,?,?,?,?,?)";
        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, endereco.getCidade());
            pstmt.setString(2, endereco.getRua());
            pstmt.setString(3, endereco.getCep());
            pstmt.setString(4, endereco.getComplemento());
            pstmt.setString(5, endereco.getNumero());
            pstmt.setString(6, endereco.getEstado());

            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // Retorna o ID gerado
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir endereço: " + e.getMessage(), e);
        }
        return -1; // Retorna -1 se não obteve o ID
    }

    // Método para editar um usuário existente com base no ID
    public boolean editarUsuarioPorId(int id, String nome, String telefone, String senha, String email, String cpf, String data_nascimento) throws SQLException {
        String sql = "UPDATE usuario SET nome = ? WHERE id = ?";

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Define os novos valores para o tipo de produto
            pstmt.setString(1, nome);
            pstmt.setInt(2, id);

            // Executa a atualização e verifica se linhas foram afetadas
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para excluir um usuário pelo ID
    public boolean excluirUsuarioPorId(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }


    // Método para buscar um usuário pelo ID
    public Usuario buscarUsuarioPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        Usuario usuario = null;

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTrocadinhas(rs.getInt("trocadinhas"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCpf(rs.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }


    // Método para buscar um usuário pelo email
    public Usuario buscarUsuarioPorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        Usuario usuario = null;

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTrocadinhas(rs.getInt("trocadinhas"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCpf(rs.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    // Método para mostrar todos os usuários
    public List<Usuario> listarUsuario() throws SQLException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "SELECT * FROM usuario";
        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTrocadinhas(rs.getInt("trocadinhas"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDtNascimento(rs.getString("dt_nascimento"));
                usuarios.add(usuario);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
