package com.springboot.SistemaWebBombeiros.models;

import javax.persistence.*;

@Entity
public class Morador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false)
    private String nome;
    @Column(unique=true,nullable=false)
    private String cpf;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String telefone1;
    private String telefone2;
    @Column(nullable=false)
    private String cep;
    @Column(nullable=false)
    private String endereco;
    private String numeroEndereco;
    @Column(nullable=false)
    private String bairro;
    @Column(nullable=false)
    private String cidade;
    @Column(nullable=false)
    private String tipoEdificacao;
    @Column(nullable=false)
    private int numeroMoradores;
    @Column(nullable=false)
    private String temBotijao;
    @Column(nullable = true)
    private int qtdBotijao;
    private String longitude;
    private String latitude;
    
    public Morador() {
    }

    public Morador(int id, String nome, String cpf, String email, String telefone1, String telefone2, String cep,
            String endereco, String numeroEndereco, String bairro, String cidade, String tipoEdificacao,
            int numeroMoradores, String temBotijao, int qtdBotijao, String longitude, String latitude) {
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
        this.longitude = longitude;
        this.latitude = latitude;
    }

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

    public int getNumeroMoradores() {
        return numeroMoradores;
    }

    public void setNumeroMoradores(int numeroMoradores) {
        this.numeroMoradores = numeroMoradores;
    }

    public String getTemBotijao() {
        return temBotijao;
    }

    public void setTemBotijao(String temBotijao) {
        this.temBotijao = temBotijao;
    }

    public int getQtdBotijao() {
        return qtdBotijao;
    }

    public void setQtdBotijao(int qtdBotijao) {
        this.qtdBotijao = qtdBotijao;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getlatitude() {
        return latitude;
    }

    public void setlatitude(String latitude) {
        this.latitude = latitude;
    } 

    
    
}
