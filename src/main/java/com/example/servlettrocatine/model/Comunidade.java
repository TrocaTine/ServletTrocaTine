package com.example.servlettrocatine.model;

public class Comunidade {
    private int id; // Identificador único da comunidade
    private String nome; // Nome da comunidade
    private String criador; // Nome do criador da comunidade
    private String descricao; // Descrição da comunidade
    private int qntIntegrantes; // Quantidade de integrantes na comunidade
    private String fotoPerfil; // Foto de perfil da comunidade

    // Construtor padrão sem parâmetros
    public Comunidade() {
    }

    // Construtor com parâmetros para inicializar todos os atributos
    public Comunidade(int id, String nome, String criador, String descricao, int qntIntegrantes, String fotoPerfil) {
        this.id = id; // Inicializa o ID da comunidade
        this.nome = nome; // Inicializa o nome da comunidade
        this.criador = criador; // Inicializa o criador da comunidade
        this.descricao = descricao; // Inicializa a descrição da comunidade
        this.qntIntegrantes = qntIntegrantes; // Inicializa a quantidade de integrantes
        this.fotoPerfil = fotoPerfil; // Inicializa a foto de perfil da comunidade
    }

    // Construtor para inicializar sem o ID (geralmente usado para novos registros)
    public Comunidade(String nome, String criador, String descricao, int qntIntegrantes, String fotoPerfil) {
        this.nome = nome;
        this.criador = criador;
        this.descricao = descricao;
        this.qntIntegrantes = qntIntegrantes;
        this.fotoPerfil = fotoPerfil;
    }

    // Getters e Setters para acessar e modificar os atributos da comunidade
    public int getId() {
        return id; // Retorna o ID da comunidade
    }

    public String getNome() {
        return nome; // Retorna o nome da comunidade
    }

    public void setNome(String nome) {
        this.nome = nome; // Define o nome da comunidade
    }

    public String getCriador() {
        return criador; // Retorna o nome do criador da comunidade
    }

    public void setCriador(String criador) {
        this.criador = criador; // Define o nome do criador da comunidade
    }

    public String getDescricao() {
        return descricao; // Retorna a descrição da comunidade
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao; // Define a descrição da comunidade
    }

    public int getQntIntegrantes() {
        return qntIntegrantes; // Retorna a quantidade de integrantes da comunidade
    }

    public void setQntIntegrantes(int qntIntegrantes) {
        this.qntIntegrantes = qntIntegrantes; // Define a quantidade de integrantes
    }

    public String getFotoPerfil() {
        return fotoPerfil; // Retorna a foto de perfil da comunidade
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil; // Define a foto de perfil da comunidade
    }

    // Método toString para representar a comunidade como uma String
    @Override
    public String toString() {
        return "Comunidade{" +
                "id=" + id + // Exibe o ID da comunidade
                ", nome='" + nome + '\'' + // Exibe o nome da comunidade
                ", criador='" + criador + '\'' + // Exibe o nome do criador
                ", descricao='" + descricao + '\'' + // Exibe a descrição da comunidade
                ", qntIntegrantes=" + qntIntegrantes + // Exibe a quantidade de integrantes
                ", fotoPerfil='" + fotoPerfil + '\'' + // Exibe a foto de perfil
                '}'; // Retorna uma descrição legível da comunidade
    }
}
