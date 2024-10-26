package com.example.servlettrocatine.Model;

public class Categoria {
    private int id;
    private String tipoProduto;

    // Construtor padrão
    public Categoria() {
    }

    // Construtor com parâmetros
    public Categoria(int id, String tipoProduto) {
        this.id = id;
        this.tipoProduto = tipoProduto;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", tipoProduto='" + tipoProduto + '\'' +
                '}';
    }
}
