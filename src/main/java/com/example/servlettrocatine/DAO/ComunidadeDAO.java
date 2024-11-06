package com.example.servlettrocatine.DAO;

import com.example.servlettrocatine.model.Comunidade;
import com.example.servlettrocatine.model.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComunidadeDAO {
    // Instância da classe Conexao para gerenciar a conexão com o banco de dados
    Conexao conexao = new Conexao();

    // Método para inserir uma nova comunidade no banco de dados
    public boolean inserirComunidade(Comunidade comunidade) {
        String sql = "INSERT INTO comunidade (nome, criador, descricao, qnt_integrantes, foto_perfil) VALUES (?, ?, ?, ?, ?)";

        try {
            // Conectando ao banco de dados
            Connection conn = conexao.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Definindo os parâmetros da query
            pstmt.setString(1, comunidade.getNome());
            pstmt.setString(2, comunidade.getCriador());
            pstmt.setString(3, comunidade.getDescricao());
            pstmt.setInt(4, comunidade.getQntIntegrantes());
            pstmt.setString(5, comunidade.getFotoPerfil());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Desconectando do banco de dados
            conexao.desconectar();
        }
    }

    // Método para editar uma comunidade pelo ID
    public boolean editarComunidadePorId(Comunidade comunidade) throws SQLException {
        String sql = "UPDATE comunidade SET nome = ?, criador = ?, descricao = ?, qnt_integrantes = ?, foto_perfil = ? WHERE id = ?";

        try {
            Connection conn = conexao.conectar();
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // Definindo os parâmetros da query
                pstmt.setString(1, comunidade.getNome());
                pstmt.setString(2, comunidade.getCriador());
                pstmt.setString(3, comunidade.getDescricao());
                pstmt.setInt(4, comunidade.getQntIntegrantes());
                pstmt.setString(5, comunidade.getFotoPerfil());
                pstmt.setInt(6, comunidade.getId());

                // Executa a atualização e retorna o sucesso
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    // Método para buscar uma comunidade pelo ID
    public Comunidade buscarComunidadePorId(int id) throws SQLException {
        String sql = "SELECT * FROM comunidade WHERE id = ?";
        Comunidade comunidade = null;

        try {
            Connection conn = conexao.conectar();
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);

                // Executa a consulta e cria um objeto Comunidade
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    comunidade = new Comunidade(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("criador"),
                            rs.getString("descricao"),
                            rs.getInt("qnt_integrantes"),
                            rs.getString("foto_perfil")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar();
        }

        return comunidade;
    }

    // Método para buscar comunidades pelo nome
    public List<Comunidade> buscarComunidadePorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM comunidade WHERE nome = ?";
        List<Comunidade> comunidades = new ArrayList<>();

        try {
            Connection conn = conexao.conectar();
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nome);

                // Executa a consulta e cria uma lista de objetos Comunidade
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Comunidade comunidade = new Comunidade();
                    comunidade.setNome(rs.getString("nome"));
                    comunidade.setCriador(rs.getString("criador"));
                    comunidade.setDescricao(rs.getString("descricao"));
                    comunidade.setQntIntegrantes(rs.getInt("qnt_integrantes"));
                    comunidade.setFotoPerfil(rs.getString("foto_perfil"));
                    comunidades.add(comunidade);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar();
        }

        return comunidades;
    }

    // Método para excluir uma comunidade pelo ID
    public boolean excluirComunidadePorId(int id) throws SQLException {
        String sql = "DELETE FROM comunidade WHERE id = ?";

        try {
            Connection conn = conexao.conectar();
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);

                // Executa a exclusão e verifica se foi bem-sucedida
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    // Método para excluir uma comunidade pelo nome
    public boolean excluirComunidadePorNome(String nome) throws SQLException {
        String sql = "DELETE FROM comunidade WHERE nome = ?";

        try {
            Connection conn = conexao.conectar();
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nome);

                // Executa a exclusão e verifica se foi bem-sucedida
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    // Método para listar todas as comunidades no banco de dados
    public List<Comunidade> listarTodasComunidades() throws SQLException {
        String sql = "SELECT * FROM comunidade";
        List<Comunidade> comunidades = new ArrayList<>();

        try {
            Connection conn = conexao.conectar();
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                // Executa a consulta e cria uma lista de objetos Comunidade
                while (rs.next()) {
                    comunidades.add(new Comunidade(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("criador"),
                            rs.getString("descricao"),
                            rs.getInt("qnt_integrantes"),
                            rs.getString("foto_perfil")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar();
        }

        return comunidades;
    }
}
