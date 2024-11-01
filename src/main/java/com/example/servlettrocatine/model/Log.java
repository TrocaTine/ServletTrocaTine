package com.example.servlettrocatine.model;

public class Log {
    //Atributos da classe log
    private int id;
    private String operacao;
    private String tabela;
    private String query;
    private String data;
    private int idadm;

    //Construtores da classe log
    public Log(int id, String operacao, String tabela, String query, String data, int idadm) {
        this.id = id;
        this.operacao = operacao;
        this.tabela = tabela;
        this.query = query;
        this.data = data;
        this.idadm = idadm;
    }

    public Log( String operacao, String tabela, String query, String data, int idadm){
        this.operacao = operacao;
        this.tabela = tabela;
        this.query = query;
        this.data = data;
        this.idadm = idadm;
    }

    public Log(String operacao, String tabela, String query, int idadm){
        this.operacao = operacao;
        this.tabela = tabela;
        this.query = query;
        this.idadm = idadm;
    }

    public Log() {

    }
    //toString da classe log
     public String toString() {
        return "Log_consultas [operacao=" + operacao + ", tabela=" + tabela + ", query=" + query + ", data=" + data + ", idadm=" + idadm + "]";
     }

     //Getters and Setters da classe log
    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdadm() {
        return idadm;
    }

    public void setIdadm(int idadm) {
        this.idadm = idadm;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
