package com.springboot.SistemaWebBombeiros.models;

public class Morador {
    private Number id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone1;
    private String telefone2;
    private String cep;
    private String endereco;
    private String numeroEndereco;
    private String bairro;
    private String cidade;
    private String tipoEdificacao;
    private Number numeroMoradores;
    private String temBotijao;
    private Number qtdBotijao;
    
    public Morador() {
    }

    public Morador(Number id, String nome, String cpf, String email, String telefone1, String telefone2, String cep,
            String endereco, String numeroEndereco, String bairro, String cidade, String tipoEdificacao,
            Number numeroMoradores, String temBotijao, Number qtdBotijao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cep = cep;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.tipoEdificacao = tipoEdificacao;
        this.numeroMoradores = numeroMoradores;
        this.temBotijao = temBotijao;
        this.qtdBotijao = qtdBotijao;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipoEdificacao() {
        return tipoEdificacao;
    }

    public void setTipoEdificacao(String tipoEdificacao) {
        this.tipoEdificacao = tipoEdificacao;
    }

    public Number getNumeroMoradores() {
        return numeroMoradores;
    }

    public void setNumeroMoradores(Number numeroMoradores) {
        this.numeroMoradores = numeroMoradores;
    }

    public String getTemBotijao() {
        return temBotijao;
    }

    public void setTemBotijao(String temBotijao) {
        this.temBotijao = temBotijao;
    }

    public Number getQtdBotijao() {
        return qtdBotijao;
    }

    public void setQtdBotijao(Number qtdBotijao) {
        this.qtdBotijao = qtdBotijao;
    }

    
    
}
