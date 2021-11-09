package com.springboot.sistemawebbombeiros.models;

import javax.persistence.*;

@Entity
public class Edificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    private Integer numeroMoradores;
    @Column(nullable=false)
    private String temBotijao;
    @Column(nullable = true)
    private Integer qtdBotijao;
    private String longitude;
    private String latitude;
    
    public Edificacao() {
    }

    public Edificacao(Integer id, String nome, String cpf, String email, String telefone1, String telefone2, String cep,
            String endereco, String numeroEndereco, String bairro, String cidade, String tipoEdificacao,
            Integer numeroMoradores, String temBotijao, Integer qtdBotijao, String longitude, String latitude) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getNumeroMoradores() {
        return numeroMoradores;
    }

    public void setNumeroMoradores(Integer numeroMoradores) {
        this.numeroMoradores = numeroMoradores;
    }

    public String getTemBotijao() {
        return temBotijao;
    }

    public void setTemBotijao(String temBotijao) {
        this.temBotijao = temBotijao;
    }

    public Integer getQtdBotijao() {
        return qtdBotijao;
    }

    public void setQtdBotijao(Integer qtdBotijao) {
        this.qtdBotijao = qtdBotijao;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    } 
    
}
