package com.example.servlettrocatine.DAO;

import com.example.servlettrocatine.model.Conexao;
import com.example.servlettrocatine.model.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagDAO {
    // Instância do gerenciador de conexões para interagir com o banco de dados
    private final Conexao conexao = new Conexao();

    // Método para inserir uma nova tag no banco de dados
    public boolean inserirTag(Tag tag) throws SQLException {
        // SQL para inserir uma nova tag
        String sql = "INSERT INTO tag (genero, cor, tamanho, qualidade, idcategoria) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conexao.conectar(); // Conecta ao banco de dados
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL
            // Define os valores dos parâmetros da query
            pstmt.setString(1, tag.getGenero());
            pstmt.setString(2, tag.getCor());
            pstmt.setString(3, tag.getTamanho());
            pstmt.setString(4, tag.getQualidade());
            pstmt.setInt(5, tag.getIdCategoria());

            pstmt.executeUpdate(); // Executa a inserção
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime a stack trace
            return false;
        }
    }

    // Método para atualizar uma tag existente no banco de dados com base no ID
    public boolean editarTagPorId(int id, Tag novaTag) throws SQLException {
        // SQL para atualizar uma tag existente
        String sql = "UPDATE tag SET genero = ?, cor = ?, tamanho = ?, qualidade = ?, idcategoria = ? WHERE id = ?";

        try (Connection conn = conexao.conectar(); // Conecta ao banco de dados
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL
            // Define os valores dos parâmetros da query
            pstmt.setString(1, novaTag.getGenero());
            pstmt.setString(2, novaTag.getCor());
            pstmt.setString(3, novaTag.getTamanho());
            pstmt.setString(4, novaTag.getQualidade());
            pstmt.setInt(5, novaTag.getIdCategoria());
            pstmt.setInt(6, id); // Define o ID da tag que será atualizada

            return pstmt.executeUpdate() > 0; // Retorna true se a atualização for bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime a stack trace
            return false;
        }
    }

    // Método para buscar uma tag no banco de dados pelo ID
    public Tag buscarTagPorId(int id) throws SQLException {
        // SQL para buscar uma tag pelo ID
        String sql = "SELECT * FROM tag WHERE id = ?";
        Tag tag = null;

        try (Connection conn = conexao.conectar(); // Conecta ao banco de dados
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL
            pstmt.setInt(1, id); // Define o parâmetro do ID na query
            ResultSet rs = pstmt.executeQuery(); // Executa a consulta e obtém os resultados

            if (rs.next()) { // Verifica se encontrou algum resultado
                // Cria uma instância de Tag com os dados obtidos do banco de dados
                String genero = rs.getString("genero");
                String cor = rs.getString("cor");
                String tamanho = rs.getString("tamanho");
                String qualidade = rs.getString("qualidade");
                int idcategoria = rs.getInt("idcategoria");
                tag = new Tag(id, genero, cor, tamanho, qualidade, idcategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime a stack trace
        }

        return tag; // Retorna o objeto Tag ou null se não encontrado
    }

    // Método para excluir uma tag do banco de dados pelo ID
    public boolean excluirTagPorId(int id) throws SQLException {
        // SQL para excluir uma tag pelo ID
        String sql = "DELETE FROM tag WHERE id = ?";

        try (Connection conn = conexao.conectar(); // Conecta ao banco de dados
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL
            pstmt.setInt(1, id); // Define o parâmetro do ID na query
            return pstmt.executeUpdate() > 0; // Retorna true se a exclusão for bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime a stack trace
            return false;
        }
    }

    // Método para listar todas as tags no banco de dados
    public List<Tag> listarTodasTags() throws SQLException {
        // SQL para buscar todas as tags
        String sql = "SELECT * FROM tag";
        List<Tag> tags = new ArrayList<>(); // Lista para armazenar as tags

        try (Connection conn = conexao.conectar(); // Conecta ao banco de dados
             PreparedStatement pstmt = conn.prepareStatement(sql); // Prepara a instrução SQL
             ResultSet rs = pstmt.executeQuery()) { // Executa a consulta e obtém os resultados

            while (rs.next()) { // Para cada linha retornada pela consulta
                // Cria uma instância de Tag com os dados obtidos
                int id = rs.getInt("id");
                String genero = rs.getString("genero");
                String cor = rs.getString("cor");
                String tamanho = rs.getString("tamanho");
                String qualidade = rs.getString("qualidade");
                int idcategoria = rs.getInt("idcategoria");
                tags.add(new Tag(id, genero, cor, tamanho, qualidade, idcategoria)); // Adiciona à lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime a stack trace
        }

        return tags; // Retorna a lista de todas as tags
    }
}
