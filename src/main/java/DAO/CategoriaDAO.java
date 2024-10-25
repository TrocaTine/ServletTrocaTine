
package DAO;



import com.example.servlettrocatine.Model.Categoria;
import com.example.servlettrocatine.Model.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDAO {
    // Instância da classe Conexao para gerenciar a conexão com o banco de dados
    Conexao conexao = new Conexao();

    // Método para inserir uma nova categoria no banco de dados
    public boolean inserirCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (tipo_produto) VALUES (?)";

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Prepara e executa a instrução SQL para inserir a categoria
            pstmt.setString(1, categoria.getTipoProduto());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para editar uma categoria existente com base no ID
    public boolean editarCategoriaPorId(int id, Categoria categoriaAtualizada) throws SQLException {
        String sql = "UPDATE categoria SET tipo_produto = ? WHERE id = ?";

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Define os novos valores para o tipo de produto
            pstmt.setString(1, categoriaAtualizada.getTipoProduto());
            pstmt.setInt(2, id);

            // Executa a atualização e verifica se linhas foram afetadas
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para buscar uma categoria no banco de dados pelo ID
    public Categoria buscarCategoriaPorId(int id) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE id = ?";

        Categoria categoria = null;

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            // Executa a consulta e obtém os resultados
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String tipoProduto = rs.getString("tipo_produto");

                // Cria uma nova instância de Categoria com os dados recuperados
                categoria = new Categoria(id, tipoProduto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoria; // Retorna a categoria ou null se não encontrada
    }

    // Método para excluir uma categoria do banco de dados pelo ID
    public boolean excluirCategoriaPorId(int id) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id = ?";

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            // Executa a exclusão e verifica se linhas foram afetadas
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
