package com.example.servlettrocatine.model;

public class Categoria {
    private int id; // Identificador único da categoria
    private String tipoProduto; // Tipo de produto relacionado à categoria

    // Construtor padrão sem parâmetros
    public Categoria() {
    }

    // Construtor com parâmetros para inicializar os atributos id e tipoProduto
    public Categoria(int id, String tipoProduto) {
        this.id = id; // Inicializa o ID da categoria
        this.tipoProduto = tipoProduto; // Inicializa o tipo de produto da categoria
    }

    // Getters e Setters para acessar e modificar os atributos
    public int getId() {
        return id; // Retorna o ID da categoria
    }

    public String getTipoProduto() {
        return tipoProduto; // Retorna o tipo de produto da categoria
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto; // Define o tipo de produto da categoria
    }

    // Método toString para retornar uma representação em String do objeto
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id + // Exibe o ID da categoria
                ", tipoProduto='" + tipoProduto + '\'' + // Exibe o tipo de produto da categoria
                '}'; // Retorna uma descrição legível da categoria
    }
}
