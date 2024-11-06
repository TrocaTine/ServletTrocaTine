package com.example.servlettrocatine.DAO;

import com.example.servlettrocatine.model.Conexao;
import com.example.servlettrocatine.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Instância do gerenciador de conexões para interagir com o banco de dados
    Conexao conexao = new Conexao();

    // Método para inserir um novo usuário no banco de dados
    public boolean inserirUsuario(Usuario usuario) throws SQLException {
        // SQL para inserir um novo usuário
        String sql = "INSERT INTO usuario (nome, sobrenome, telefone, senha, trocadinhas, email, cpf, dt_nascimento, idendereco) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conn = conexao.conectar(); // Conecta ao banco de dados
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL
            // Define os valores dos parâmetros da query
            pstmt.setString(1, usuario.getNome()); // nome
            pstmt.setString(2, usuario.getSobrenome());
            pstmt.setString(3, usuario.getTelefone()); // telefone
            pstmt.setString(4, usuario.getSenha()); // senha
            pstmt.setInt(5, 5); // número inicial de moedas do site
            pstmt.setString(6, usuario.getEmail()); // email
            pstmt.setString(7, usuario.getCpf()); // cpf
            pstmt.setDate(8, java.sql.Date.valueOf(usuario.getDtNascimento())); // dt_nascimento como String
            pstmt.setInt(9, usuario.getIdEndereco()); // idendereco é pego do jsp

            pstmt.executeUpdate(); // Executa a inserção
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime a stack trace
            return false;
        } finally {
            conexao.desconectar(); // Desconecta após a execução
        }
    }

    // Método para editar um usuário existente com base no ID
    public boolean editarUsuarioPorId(int id, String nome, String sobrenome, String telefone, String senha, String email, String cpf, String data_nascimento, int idendereco) throws SQLException {
        // SQL para atualizar os dados de um usuário
        String sql = "UPDATE usuario SET nome = ?, sobrenome = ?, telefone = ?, senha = ?, email = ?, cpf = ?, dt_nascimento =?, idendereco = ? WHERE id = ?";

        try (Connection conn = conexao.conectar(); // Conecta ao banco de dados
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL

            // Define os novos valores para o usuário
            pstmt.setString(1, nome);
            pstmt.setString(2, sobrenome);
            pstmt.setString(3, telefone);
            pstmt.setString(4, senha);
            pstmt.setString(5, email);
            pstmt.setString(6, cpf);
            pstmt.setDate(7, java.sql.Date.valueOf(data_nascimento));
            pstmt.setInt(8, idendereco);
            pstmt.setInt(9, id); // Define o ID do usuário que será atualizado

            // Executa a atualização e verifica se linhas foram afetadas
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Retorna true se a atualização for bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime a stack trace
            return false;
        }
    }

    // Método para excluir um usuário pelo ID
    public boolean excluirUsuarioPorId(int id) throws SQLException {
        // SQL para excluir um usuário pelo ID
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (Connection conn = conexao.conectar(); // Conecta ao banco de dados
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL

            pstmt.setInt(1, id); // Define o parâmetro do ID na query
            pstmt.executeUpdate(); // Executa a exclusão

            return true; // Retorna true se a exclusão for bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime a stack trace
            return false;
        }
    }

    // Método para buscar um usuário pelo ID
    public Usuario buscarUsuarioPorId(int id) throws SQLException {
        // SQL para buscar um usuário pelo ID
        String sql = "SELECT * FROM usuario WHERE id = ?";
        Usuario usuario = null;

        try (Connection conn = conexao.conectar(); // Conecta ao banco de dados
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL

            pstmt.setInt(1, id); // Define o parâmetro do ID na query
            ResultSet rs = pstmt.executeQuery(); // Executa a consulta e obtém os resultados

            if (rs.next()) { // Se encontrar um usuário
                // Cria uma instância de Usuario com os dados obtidos
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTrocadinhas(rs.getInt("trocadinhas"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDtNascimento(rs.getString("dt_nascimento"));
                usuario.setCpf(rs.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime a stack trace
        }
        return usuario; // Retorna o usuário ou null se não encontrado
    }

    // Método para buscar um usuário pelo email
    public Usuario buscarUsuarioPorEmail(String email) throws SQLException {
        // SQL para buscar um usuário pelo email
        String sql = "SELECT * FROM usuario WHERE email = ?";
        Usuario usuario = null;

        try (Connection conn = conexao.conectar(); // Conecta ao banco de dados
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL

            pstmt.setString(1, email); // Define o parâmetro do email na query
            ResultSet rs = pstmt.executeQuery(); // Executa a consulta e obtém os resultados

            if (rs.next()) { // Se encontrar um usuário
                // Cria uma instância de Usuario com os dados obtidos
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTrocadinhas(rs.getInt("trocadinhas"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDtNascimento(rs.getString("dt_nascimento"));
                usuario.setCpf(rs.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime a stack trace
        }
        return usuario; // Retorna o usuário ou null se não encontrado
    }

    // Método para listar todos os usuários
    public List<Usuario> listarUsuario() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>(); // Lista para armazenar os usuários
        String sql = "SELECT * FROM usuario"; // SQL para buscar todos os usuários
        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.conectar(); // Conecta ao banco de dados
            PreparedStatement pstmt = conn.prepareStatement(sql); // Prepara a instrução SQL
            ResultSet rs = pstmt.executeQuery(); // Executa a consulta e obtém os resultados

            while (rs.next()) { // Para cada linha retornada
                // Cria uma instância de Usuario com os dados obtidos
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTrocadinhas(rs.getInt("trocadinhas"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDtNascimento(rs.getString("dt_nascimento"));
                usuario.setIdEndereco(rs.getInt("idendereco"));
                usuarios.add(usuario); // Adiciona o usuário à lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime a stack trace
        }
        return usuarios; // Retorna a lista de usuários
    }
}
