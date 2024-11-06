package com.example.servlettrocatine.model;

public class Adm {
    private int id; // Identificador único do administrador
    private String nome; // Nome do administrador
    private String email; // Email do administrador
    private String senha; // Senha do administrador
    private int idUsuario; // ID do usuário associado ao administrador

    // Construtor com parâmetros para inicializar todos os atributos
    public Adm(int id, String nome, String email, String senha, int idUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idUsuario = idUsuario;
    }

    // Construtor padrão para inicializar o administrador sem ID
    public Adm(String nome, String email, String senha, int idUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idUsuario = idUsuario;
    }

    // Getters e Setters para acessar e modificar os atributos
    public int getId() {
        return id; // Retorna o ID do administrador
    }

    public String getNome() {
        return nome; // Retorna o nome do administrador
    }

    public void setNome(String nome) {
        this.nome = nome; // Define o nome do administrador
    }

    public String getEmail() {
        return email; // Retorna o email do administrador
    }

    public void setEmail(String email) {
        this.email = email; // Define o email do administrador
    }

    public String getSenha() {
        return senha; // Retorna a senha do administrador
    }

    public void setSenha(String senha) {
        this.senha = senha; // Define a senha do administrador
    }

    public int getIdUsuario() {
        return idUsuario; // Retorna o ID do usuário associado ao administrador
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario; // Define o ID do usuário associado ao administrador
    }

    // Método toString para retornar uma representação em String do objeto
    @Override
    public String toString() {
        return "Adm{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", idUsuario=" + idUsuario +
                '}'; // Retorna uma descrição legível do administrador
    }
}
