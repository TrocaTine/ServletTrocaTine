package com.example.servlettrocatine.model;

public class Endereco {
    private int id; // Identificador único do endereço
    private String cep; // Código Postal
    private String rua; // Nome da rua
    private String numero; // Número da residência ou estabelecimento
    private String cidade; // Nome da cidade
    private String estado; // Nome do estado
    private String complemento; // Complemento do endereço (ex: apartamento, bloco)

    // Construtor padrão, sem parâmetros
    public Endereco() {
    }

    // Construtor com parâmetros para inicializar todos os atributos do endereço
    public Endereco(int id, String cep, String rua, String numero, String cidade, String estado, String complemento) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }

    // Getters e Setters para acessar e modificar os atributos
    public int getId() {
        return id; // Retorna o id do endereço
    }

    public String getCep() {
        return cep; // Retorna o cep do endereço
    }

    public void setCep(String cep) {
        this.cep = cep; // Define o valor do cep
    }

    public String getRua() {
        return rua; // Retorna o nome da rua
    }

    public void setRua(String rua) {
        this.rua = rua; // Define o valor da rua
    }

    public String getNumero() {
        return numero; // Retorna o número da residência ou estabelecimento
    }

    public void setNumero(String numero) {
        this.numero = numero; // Define o valor do número
    }

    public String getCidade() {
        return cidade; // Retorna o nome da cidade
    }

    public void setCidade(String cidade) {
        this.cidade = cidade; // Define o valor da cidade
    }

    public String getEstado() {
        return estado; // Retorna o nome do estado
    }

    public void setEstado(String estado) {
        this.estado = estado; // Define o valor do estado
    }

    public String getComplemento() {
        return complemento; // Retorna o complemento do endereço
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento; // Define o valor do complemento
    }

    // Método toString() que retorna uma representação em String do objeto Endereco
    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id + // Exibe o id
                ", cep='" + cep + '\'' + // Exibe o cep
                ", rua='" + rua + '\'' + // Exibe a rua
                ", numero='" + numero + '\'' + // Exibe o número
                ", cidade='" + cidade + '\'' + // Exibe a cidade
                ", estado='" + estado + '\'' + // Exibe o estado
                ", complemento='" + complemento + '\'' + // Exibe o complemento
                '}'; // Fecha a representação em string
    }
}
