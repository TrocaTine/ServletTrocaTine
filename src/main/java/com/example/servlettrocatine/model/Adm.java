package com.example.servlettrocatine.model;

import com.example.servlettrocatine.DAO.SenhaHash;

public class Adm {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private int idUsuario;

    // Construtor padrão
    public Adm(String nome, String email, String senha, int idUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idUsuario = idUsuario;
    }

    // Construtor com parâmetros
    public Adm(int id, String nome, String email, String senha, int idUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idUsuario = idUsuario;
    }

    public Adm(String nome, String email, SenhaHash cripto, int idUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = cripto.getSenha();
        this.idUsuario = idUsuario;
    }



    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdUsuario() { return idUsuario; }

    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    @Override
    public String toString() {
        return "Adm{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
