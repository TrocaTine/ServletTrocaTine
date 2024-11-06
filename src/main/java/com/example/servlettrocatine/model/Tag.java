package com.example.servlettrocatine.model;

public class Tag {
    // Atributos da classe Tag
    private int id; // Identificador único da tag
    private String genero; // Gênero associado à tag (ex: Masculino, Feminino, Unissex)
    private String cor; // Cor associada à tag (ex: Azul, Vermelho)
    private String tamanho; // Tamanho associado à tag (ex: P, M, G)
    private String qualidade; // Qualidade associada à tag (ex: Alta, Média, Baixa)
    private int idCategoria; // Identificador da categoria associada à tag

    // Construtor com todos os atributos
    public Tag(int id, String genero, String cor, String tamanho, String qualidade, int idCategoria) {
        this.id = id; // Inicializa o id da tag
        this.genero = genero; // Inicializa o gênero
        this.cor = cor; // Inicializa a cor
        this.tamanho = tamanho; // Inicializa o tamanho
        this.qualidade = qualidade; // Inicializa a qualidade
        this.idCategoria = idCategoria; // Inicializa o id da categoria
    }

    // Construtor sem o id, usado para criar uma nova tag onde o id será gerado automaticamente
    public Tag(String genero, String cor, String tamanho, String qualidade, int idCategoria) {
        this.genero = genero; // Inicializa o gênero
        this.cor = cor; // Inicializa a cor
        this.tamanho = tamanho; // Inicializa o tamanho
        this.qualidade = qualidade; // Inicializa a qualidade
        this.idCategoria = idCategoria; // Inicializa o id da categoria
    }

    // Getters e Setters para acessar e modificar os atributos da classe Tag

    public int getId() {
        return id; // Retorna o id da tag
    }

    public String getGenero() {
        return genero; // Retorna o gênero da tag
    }

    public void setGenero(String genero) {
        this.genero = genero; // Define o gênero da tag
    }

    public String getCor() {
        return cor; // Retorna a cor da tag
    }

    public void setCor(String cor) {
        this.cor = cor; // Define a cor da tag
    }

    public String getTamanho() {
        return tamanho; // Retorna o tamanho da tag
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho; // Define o tamanho da tag
    }

    public String getQualidade() {
        return qualidade; // Retorna a qualidade da tag
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade; // Define a qualidade da tag
    }

    public int getIdCategoria() {
        return idCategoria; // Retorna o id da categoria associada à tag
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria; // Define o id da categoria associada à tag
    }
}
