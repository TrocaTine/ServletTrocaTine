package com.example.servlettrocatine.model;

// Classe que representa um usuário no sistema
public class Usuario {

    // Atributos do usuário
    private int id; // Identificador único do usuário
    private String nome; // Nome do usuário
    private String sobrenome; // Sobrenome do usuário
    private String telefone; // Telefone de contato do usuário
    private String senha; // Senha para autenticação do usuário
    private int trocadinhas; // Pontuação ou saldo de "trocadinhas" do usuário
    private String email; // Endereço de email do usuário
    private String cpf; // CPF do usuário
    private String dtNascimento; // Data de nascimento do usuário (pode ser ajustado para LocalDate se necessário)
    private String fotoPerfil; // URL ou caminho para a foto de perfil do usuário
    private int idAdm; // ID do administrador que gerencia o usuário
    private int idEndereco; // ID do endereço associado ao usuário

    // Construtor padrão, utilizado para criar um usuário sem parâmetros
    public Usuario() {
    }

    // Construtor com parâmetros para inicializar todos os campos do usuário
    public Usuario(int id, String nome, String sobrenome, String telefone, String senha,
                   int trocadinhas, String email, String cpf, String dtNascimento,
                   String fotoPerfil, int idAdm, int idEndereco) {
        this.id = id; // Inicializa o ID do usuário
        this.nome = nome; // Inicializa o nome do usuário
        this.sobrenome = sobrenome; // Inicializa o sobrenome do usuário
        this.telefone = telefone; // Inicializa o telefone do usuário
        this.senha = senha; // Inicializa a senha do usuário
        this.trocadinhas = trocadinhas; // Inicializa o saldo de "trocadinhas"
        this.email = email; // Inicializa o email do usuário
        this.cpf = cpf; // Inicializa o CPF do usuário
        this.dtNascimento = dtNascimento; // Inicializa a data de nascimento do usuário
        this.fotoPerfil = fotoPerfil; // Inicializa a foto de perfil do usuário
        this.idAdm = idAdm; // Inicializa o ID do administrador responsável
        this.idEndereco = idEndereco; // Inicializa o ID do endereço do usuário
    }

    // Construtor com parâmetros mais simples (sem foto de perfil e ID de administrador)
    public Usuario(int id, String nome, String telefone, String senha, String email, String cpf, String dtNascimento) {
        this.id = id; // Inicializa o ID do usuário
        this.nome = nome; // Inicializa o nome do usuário
        this.telefone = telefone; // Inicializa o telefone do usuário
        this.senha = senha; // Inicializa a senha do usuário
        this.email = email; // Inicializa o email do usuário
        this.cpf = cpf; // Inicializa o CPF do usuário
        this.dtNascimento = dtNascimento; // Inicializa a data de nascimento do usuário
    }

    // Construtor para criação de um usuário com valores nulos, provavelmente para casos específicos
    public Usuario(int id, String nome, String sobrenome, String telefone, String senha, Integer o, String email, String cpf, Object dtNascimento, Object fotoPerfil, Object idAdm, Object idEndereco) {
        this.id = id; // Inicializa o ID do usuário
        this.nome = nome; // Inicializa o nome do usuário
        this.sobrenome = sobrenome; // Inicializa o sobrenome do usuário
        this.telefone = telefone; // Inicializa o telefone do usuário
        this.senha = senha; // Inicializa a senha do usuário
        this.trocadinhas = Integer.parseInt(null); // Inicializa o saldo de "trocadinhas" com valor nulo (erro de implementação)
        this.email = email; // Inicializa o email do usuário
        this.cpf = cpf; // Inicializa o CPF do usuário
        this.dtNascimento = null; // Inicializa a data de nascimento com valor nulo (erro de implementação)
        this.fotoPerfil = null; // Inicializa a foto de perfil com valor nulo
        this.idAdm = Integer.parseInt(null); // Inicializa o ID do administrador com valor nulo (erro de implementação)
        this.idEndereco = Integer.parseInt(null); // Inicializa o ID do endereço com valor nulo (erro de implementação)
    }

    // Construtor para criar um usuário com o endereço associado
    public Usuario(String nome, String sobrenome, String telefone, String senha, String email, String cpf, String dtNascimento, int idEndereco) {
        this.nome = nome; // Inicializa o nome do usuário
        this.sobrenome = sobrenome; // Inicializa o sobrenome do usuário
        this.telefone = telefone; // Inicializa o telefone do usuário
        this.senha = senha; // Inicializa a senha do usuário
        this.email = email; // Inicializa o email do usuário
        this.cpf = cpf; // Inicializa o CPF do usuário
        this.dtNascimento = dtNascimento; // Inicializa a data de nascimento do usuário
        this.idEndereco = idEndereco; // Inicializa o ID do endereço associado
    }

    // Getters e Setters para acessar e modificar os valores dos atributos do usuário

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTrocadinhas() {
        return trocadinhas;
    }

    public void setTrocadinhas(int trocadinhas) {
        this.trocadinhas = trocadinhas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    // Atributo para armazenar o endereço do usuário, com getter e setter
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // Método toString para representar o usuário como uma string
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", senha='" + senha + '\'' +
                ", trocadinhas=" + trocadinhas +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dtNascimento='" + dtNascimento + '\'' +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                ", idAdm=" + idAdm +
                ", idEndereco=" + idEndereco +
                '}';
    }
}
