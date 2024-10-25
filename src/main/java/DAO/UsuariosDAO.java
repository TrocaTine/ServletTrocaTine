package DAO;


import com.example.servlettrocatine.Model.Conexao;
import com.example.servlettrocatine.Model.Endereco;
import com.example.servlettrocatine.Model.Usuario;

import java.sql.*;

public class UsuariosDAO {

    Conexao conexao = new Conexao();
   // Método para inserir um novo usuário no banco de dados
    public boolean inserirUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome, sobrenome, telefone, senha, trocadinhas, email, cpf, dt_nascimento, " +
                "foto_perfil, idadm, idendereco) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Insere o endereço e obtém o ID gerado
            int idEndereco = inserirEnderecoRetornaId(usuario.getEndereco()); // Aqui passa o objeto Endereco

            if (idEndereco > 0) {
                pstmt.setString(1, usuario.getNome());
                pstmt.setString(2, usuario.getSobrenome());
                pstmt.setString(3, usuario.getTelefone());
                pstmt.setString(4, usuario.getSenha());
                pstmt.setInt(5, usuario.getTrocadinhas());
                pstmt.setString(6, usuario.getEmail());
                pstmt.setString(7, usuario.getCpf());
                pstmt.setDate(8, Date.valueOf(usuario.getDtNascimento()));
                pstmt.setString(9, usuario.getFotoPerfil());
                pstmt.setInt(10, usuario.getIdAdm());
                pstmt.setInt(11, idEndereco);

                pstmt.executeUpdate();
                return true;
            } else {
                return false; // ID do endereço não foi obtido
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir usuário: " + e.getMessage(), e);
        }
    }


    public int inserirUsuarioRetornaId(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome, telefone, senha, trocadinhas, email, cpf, dt_nascimento, idadm, " +
                "foto_perfil, idendereco) VALUES (?,?,?,?,?,?,?,?,?,?)";
        int generatedId = -1;

        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            int idEndereco = inserirEnderecoRetornaId(usuario.getEndereco());

            if (idEndereco > 0) {
                pstmt.setString(1, usuario.getNome());
                pstmt.setString(2, usuario.getTelefone());
                pstmt.setString(3, usuario.getSenha());
                pstmt.setInt(4, usuario.getTrocadinhas());
                pstmt.setString(5, usuario.getEmail());
                pstmt.setString(6, usuario.getCpf());
                pstmt.setDate(7, Date.valueOf(usuario.getDtNascimento()));
                pstmt.setInt(8, usuario.getIdAdm());
                pstmt.setString(9, usuario.getFotoPerfil());
                pstmt.setInt(10, idEndereco);

                pstmt.executeUpdate();
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir usuário e retornar ID: " + e.getMessage(), e);
        }

        return generatedId;
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

    // Método para excluir um usuário pelo ID
    public void excluirUsuarioPorId(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao excluir usuário: " + e.getMessage(), e);
        }
    }

    // Método para mostrar todos os usuários
    public void mostrarTodosUsuarios() throws SQLException {
        String sql = "SELECT * FROM usuario";
        try (Connection conn = conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String telefone = rs.getString("telefone");
                String senha = rs.getString("senha");
                int trocadinhas = rs.getInt("trocadinhas");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String dtNascimento = rs.getString("dt_nascimento");
                boolean adm = rs.getBoolean("adm");
                String fotoPerfil = rs.getString("foto_perfil");

                System.out.println("ID: " + id + " Nome: " + nome + " Sobrenome: " + sobrenome + " Telefone: " + telefone +
                        " Senha: " + senha + " Trocadinhas: " + trocadinhas + " Email: " + email + " CPF: " + cpf +
                        " Data de Nascimento: " + dtNascimento + " Administrador: " + adm +
                        " Foto do Perfil: " + fotoPerfil);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao mostrar todos os usuários: " + e.getMessage(), e);
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
                usuario.setDtNascimento(rs.getString("dt_nascimento"));
                usuario.setIdAdm(rs.getInt("idadm"));
                usuario.setFotoPerfil(rs.getString("foto_perfil"));
                // Preencher o endereço caso necessário
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar usuário por ID: " + e.getMessage(), e);
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
                usuario.setDtNascimento(rs.getString("dt_nascimento"));
                usuario.setIdAdm(rs.getInt("idadm"));
                usuario.setFotoPerfil(rs.getString("foto_perfil"));
                // Preencher o endereço caso necessário
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar usuário por email: " + e.getMessage(), e);
        }
        return usuario;
    }
}
