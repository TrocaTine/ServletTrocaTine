package com.example.servlettrocatine.model;

public class Log {
    // Atributos da classe Log que armazenam informações sobre o log de operações no banco de dados
    private int id; // Identificador único do log
    private String operacao; // Tipo de operação realizada (ex: INSERT, UPDATE, DELETE)
    private String tabela; // Nome da tabela afetada pela operação
    private String query; // A consulta SQL executada
    private String data; // Data e hora da execução da operação
    private int idadm; // Identificador do administrador que realizou a operação

    // Construtor completo com todos os atributos
    public Log(int id, String operacao, String tabela, String query, String data, int idadm) {
        this.id = id; // Inicializa o id
        this.operacao = operacao; // Inicializa a operação
        this.tabela = tabela; // Inicializa a tabela afetada
        this.query = query; // Inicializa a consulta SQL
        this.data = data; // Inicializa a data da operação
        this.idadm = idadm; // Inicializa o id do administrador
    }

    // Construtor sem o id, usado para criação de novos logs (id gerado automaticamente)
    public Log(String operacao, String tabela, String query, String data, int idadm) {
        this.operacao = operacao; // Inicializa a operação
        this.tabela = tabela; // Inicializa a tabela afetada
        this.query = query; // Inicializa a consulta SQL
        this.data = data; // Inicializa a data da operação
        this.idadm = idadm; // Inicializa o id do administrador
    }

    // Construtor sem a data, caso a data seja adicionada automaticamente ou não seja necessária
    public Log(String operacao, String tabela, String query, int idadm) {
        this.operacao = operacao; // Inicializa a operação
        this.tabela = tabela; // Inicializa a tabela afetada
        this.query = query; // Inicializa a consulta SQL
        this.idadm = idadm; // Inicializa o id do administrador
    }

    // Construtor padrão sem parâmetros
    public Log() {
    }

    // Método toString() que retorna uma representação do objeto Log em formato String
    public String toString() {
        return "Log_consultas [operacao=" + operacao + ", tabela=" + tabela +
                ", query=" + query + ", data=" + data + ", idadm=" + idadm + "]";
    }

    // Getters e Setters para acessar e modificar os atributos da classe Log
    public String getOperacao() {
        return operacao; // Retorna a operação
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao; // Define a operação
    }

    public String getTabela() {
        return tabela; // Retorna a tabela afetada
    }

    public void setTabela(String tabela) {
        this.tabela = tabela; // Define a tabela afetada
    }

    public String getQuery() {
        return query; // Retorna a consulta SQL executada
    }

    public void setQuery(String query) {
        this.query = query; // Define a consulta SQL
    }

    public String getData() {
        return data; // Retorna a data da operação
    }

    public void setData(String data) {
        this.data = data; // Define a data da operação
    }

    public int getIdadm() {
        return idadm; // Retorna o id do administrador
    }

    public void setIdadm(int idadm) {
        this.idadm = idadm; // Define o id do administrador
    }

    public int getId() {
        return id; // Retorna o id do log
    }

    public void setId(int id) {
        this.id = id; // Define o id do log
    }
}
