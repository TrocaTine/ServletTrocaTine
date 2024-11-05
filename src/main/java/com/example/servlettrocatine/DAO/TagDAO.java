package com.example.servlettrocatine.DAO;//package com.example.com.example.servlettrocatine.servlet.com.example.servlettrocatine.DAO;

import com.example.servlettrocatine.model.Conexao;
import com.example.servlettrocatine.model.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagDAO {
    // Instância do gerenciador de conexões para lidar com as conexões ao banco de dados
    private final Conexao conexao = new Conexao();

    // Método para inserir uma nova tag sem retornar o ID
    public boolean inserirTag(Tag tag) throws SQLException {
        String sql = "INSERT INTO tag (genero, cor, tamanho, qualidade, idtcategoria) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tag.getGenero());
            pstmt.setString(2, tag.getCor());
            pstmt.setString(3, tag.getTamanho());
            pstmt.setString(4, tag.getQualidade());
            pstmt.setInt(5, tag.getIdCategoria());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
            return false;
        }
    }

    // Método para editar uma tag existente com base no seu ID
    public boolean editarTagPorId(int id, Tag novaTag) throws SQLException {
        String sql = "UPDATE tag SET genero = ?, cor = ?, tamanho = ?, qualidade = ?, idtcategoria = ? WHERE id = ?";

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novaTag.getGenero());
            pstmt.setString(2, novaTag.getCor());
            pstmt.setString(3, novaTag.getTamanho());
            pstmt.setString(4, novaTag.getQualidade());
            pstmt.setInt(5, novaTag.getIdCategoria());
            pstmt.setInt(6, id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
            return false;
        }
    }
    // Método para buscar uma tag pelo ID e retornar o objeto Tag
    public Tag buscarTagPorId(int id) throws SQLException {
        String sql = "SELECT * FROM tag WHERE id = ?";
        Tag tag = null;

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String genero = rs.getString("genero");
                String cor = rs.getString("cor");
                String tamanho = rs.getString("tamanho");
                String qualidade = rs.getString("qualidade");
                int idcategoria = rs.getInt("idcategoria");
                tag = new Tag(id, genero, cor, tamanho, qualidade, idcategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
        }

        return tag;
    }

    // Método para excluir uma tag pelo ID
    public boolean excluirTagPorId(int id) throws SQLException {
        String sql = "DELETE FROM tag WHERE id = ?";

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
            return false;
        }
    }

    public List<Tag> listarTodasTags() throws SQLException {
        String sql = "SELECT * FROM tag";
        List<Tag> tags = new ArrayList<>();

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Executa a consulta e cria uma lista de objetos Tag
            while (rs.next()) {
                int id = rs.getInt("id");
                String genero = rs.getString("genero");
                String cor = rs.getString("cor");
                String tamanho = rs.getString("tamanho");
                String qualidade = rs.getString("qualidade");
                int idcategoria = rs.getInt("idcategoria");
                tags.add(new Tag(id, genero, cor, tamanho, qualidade, idcategoria));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
        }

        return tags; // Retorna a lista de tags
    }


}

