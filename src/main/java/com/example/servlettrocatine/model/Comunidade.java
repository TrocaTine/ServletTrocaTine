package com.example.servlettrocatine.model;

public class Comunidade {
    private int id;
    private String nome;
    private String criador;
    private String descricao;
    private int qntIntegrantes;
    private String fotoPerfil;

    // Construtor padrão
    public Comunidade() {
    }

    // Construtor com parâmetros
    public Comunidade(int id, String nome, String criador, String descricao, int qntIntegrantes, String fotoPerfil) {
        this.id = id;
        this.nome = nome;
        this.criador = criador;
        this.descricao = descricao;
        this.qntIntegrantes = qntIntegrantes;
        this.fotoPerfil = fotoPerfil;
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

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQntIntegrantes() {
        return qntIntegrantes;
    }

    public void setQntIntegrantes(int qntIntegrantes) {
        this.qntIntegrantes = qntIntegrantes;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    @Override
    public String toString() {
        return "Comunidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", criador='" + criador + '\'' +
                ", descricao='" + descricao + '\'' +
                ", qntIntegrantes=" + qntIntegrantes +
                ", fotoPerfil=" + fotoPerfil +
                '}';
    }
}
