package com.example.servlettrocatine.DAO;//package com.example.com.example.servlettrocatine.servlet.com.example.servlettrocatine.DAO;

import com.example.servlettrocatine.model.Conexao;
import com.example.servlettrocatine.model.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagDAO {
    // Instância do gerenciador de conexões para lidar com as conexões ao banco de dados
    private final Conexao conexao = new Conexao();

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
                int id_produto = rs.getInt("idtipo_produto");
                tags.add(new Tag(id, genero, cor, tamanho, qualidade, id_produto));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
        }

        return tags; // Retorna a lista de tags
    }

    // Método para inserir uma nova tag sem retornar o ID
    public boolean inserirTag(Tag tag) throws SQLException {
        String sql = "INSERT INTO tag (id, genero, cor, tamanho, qualidade, idtipo_produto) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tag.getId());
            pstmt.setString(2, tag.getGenero());
            pstmt.setString(3, tag.getCor());
            pstmt.setString(4, tag.getTamanho());
            pstmt.setString(5, tag.getQualidade());
            pstmt.setInt(6, tag.getIdTipo_produto());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
            return false;
        }
    }

    // Método para editar uma tag existente com base no seu ID
    public boolean editarTagPorId(int id, Tag novaTag) throws SQLException {
        String sql = "UPDATE tag SET genero = ?, cor = ?, tamanho = ?, qualidade = ?, idtipo_produto = ? WHERE id = ?";

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novaTag.getGenero());
            pstmt.setString(2, novaTag.getCor());
            pstmt.setString(3, novaTag.getTamanho());
            pstmt.setString(4, novaTag.getQualidade());
            pstmt.setInt(5, novaTag.getIdTipo_produto());
            pstmt.setInt(6, id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
            return false;
        }
    }

    // Método para buscar tags pelo gênero e retornar uma lista
    public List<Tag> buscarTagPorGenero(String genero) throws SQLException {
        String sql = "SELECT * FROM tag WHERE genero = ?";
        List<Tag> tags = new ArrayList<>();

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, genero);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String cor = rs.getString("cor");
                String tamanho = rs.getString("tamanho");
                String qualidade = rs.getString("qualidade");
                int id_produto = rs.getInt("idtipo_produto");
                tags.add(new Tag(id, genero, cor, tamanho, qualidade, id_produto));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
        }

        return tags;
    }

    // Método para buscar tags pela qualidade e retornar uma lista
    public List<Tag> buscarTagPorQualidade(String qualidade) throws SQLException {
        String sql = "SELECT * FROM tag WHERE qualidade = ?";
        List<Tag> tags = new ArrayList<>();

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, qualidade);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String genero = rs.getString("genero");
                String cor = rs.getString("cor");
                String tamanho = rs.getString("tamanho");
                int id_produto = rs.getInt("idtipo_produto");
                tags.add(new Tag(id, genero, cor, tamanho, qualidade, id_produto));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
        }

        return tags;
    }

    // Método para buscar tags pela cor e retornar uma lista
    public List<Tag> buscarTagPorCor(String cor) throws SQLException {
        String sql = "SELECT * FROM tag WHERE cor = ?";
        List<Tag> tags = new ArrayList<>();

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cor);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String genero = rs.getString("genero");
                String tamanho = rs.getString("tamanho");
                String qualidade = rs.getString("qualidade");
                int id_produto = rs.getInt("idtipo_produto");
                tags.add(new Tag(id, genero, cor, tamanho, qualidade, id_produto));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
        }

        return tags;
    }

    // Método para buscar tags pelo tamanho e retornar uma lista
    public List<Tag> buscarTagPorTamanho(String tamanho) throws SQLException {
        String sql = "SELECT * FROM tag WHERE tamanho = ?";
        List<Tag> tags = new ArrayList<>();

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tamanho);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String genero = rs.getString("genero");
                String cor = rs.getString("cor");
                String qualidade = rs.getString("qualidade");
                int id_produto = rs.getInt("idtipo_produto");
                tags.add(new Tag(id, genero, cor, tamanho, qualidade, id_produto));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with a logger
        }

        return tags;
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
                int id_produto = rs.getInt("idtipo_produto");
                tag = new Tag(id, genero, cor, tamanho, qualidade, id_produto);
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
}
