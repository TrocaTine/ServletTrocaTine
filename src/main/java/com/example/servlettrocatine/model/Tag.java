package com.example.servlettrocatine.model;

public class Tag {
    private int id;
    private String genero;
    private String cor;
    private String tamanho;
    private String qualidade;
    private int idCategoria; // Assuming you also have this field

    // Constructor with all fields
    public Tag(int id, String genero, String cor, String tamanho, String qualidade) {
        this.id = id;
        this.genero = genero;
        this.cor = cor;
        this.tamanho = tamanho;
        this.qualidade = qualidade;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
