package com.example.servlettrocatine.model;

public class Usuario {
    private int id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String senha;
    private int trocadinhas;
    private String email;
    private String cpf;
    private String dtNascimento; // Pode ser ajustado para LocalDate se preferir
    private String fotoPerfil;
    private int idAdm;
    private int idEndereco;

    // Construtor padrão
    public Usuario() {
    }

    // Construtor com parâmetros
    public Usuario(int id, String nome, String sobrenome, String telefone, String senha,
                   int trocadinhas, String email, String cpf, String dtNascimento,
                   String fotoPerfil, int idAdm, int idEndereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.senha = senha;
        this.trocadinhas = trocadinhas;
        this.email = email;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.fotoPerfil = fotoPerfil;
        this.idAdm = idAdm;
        this.idEndereco = idEndereco;
    }

    public Usuario(int id, String nome, String telefone, String senha, String email, String cpf, String dtNascimento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }

    public Usuario(int id, String nome, String sobrenome, String telefone, String senha, Integer o, String email, String cpf, Object dtNascimento, Object fotoPerfil, Object idAdm, Object idEndereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.senha = senha;
        this.trocadinhas = Integer.parseInt(null);
        this.email = email;
        this.cpf = cpf;
        this.dtNascimento = null;
        this.fotoPerfil = null;
        this.idAdm = Integer.parseInt(null);
        this.idEndereco = Integer.parseInt(null);
    }

    public Usuario(String nome, String telefone, String senha, String email, String cpf, String dtNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }

    // Getters e Setters
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

    private Endereco endereco;

    // Adicione o getter e setter para Endereco
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


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
