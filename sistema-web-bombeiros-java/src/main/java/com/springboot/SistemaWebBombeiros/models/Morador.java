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
    @Column(nullable = false)
    private String tamanhoMangueira;
    @Column(nullable = false)
    private String modeloMangueira;
    @Column(nullable = false)
    private String validadeMangueira;
    @Column(nullable = false)
    private String validadeValvula;
    @Column(nullable = false)
    private String validadeHidrante;
    @Column(nullable = false)
    private String numeroPatrimonio;
    @Column(nullable = false)
    private String ultimoTeste;
    @Column(nullable = false)
    private String statusAtividade;
    @Column(nullable = false)
    private String validadeExtintor;
    @Column(nullable = false)
    private String modeloExtintor;
    @Column(nullable = false)
    private String seloInmetro;
    @Column(nullable = false)
    private String pesoExtintor;
    @Column(nullable = false)
    private String anoExpecao;
    private String longitude;
    private String latitude;
    
    public Morador() {
    }

    public Morador(int id, String nome, String cpf, String email, String telefone1, String telefone2, String cep,
            String endereco, String numeroEndereco, String bairro, String cidade, String tipoEdificacao,
            int numeroMoradores, String temBotijao, int qtdBotijao, String tamanhoMangueira, String modeloMangueira,
            String validadeMangueira, String validadeValvula, String validadeHidrante, String numeroPatrimonio,
            String ultimoTeste, String statusAtividade, String validadeExtintor, String modeloExtintor,
            String seloInmetro, String pesoExtintor, String anoExpecao, String longitude, String latitude) {
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
        this.tamanhoMangueira = tamanhoMangueira;
        this.modeloMangueira = modeloMangueira;
        this.validadeMangueira = validadeMangueira;
        this.validadeValvula = validadeValvula;
        this.validadeHidrante = validadeHidrante;
        this.numeroPatrimonio = numeroPatrimonio;
        this.ultimoTeste = ultimoTeste;
        this.statusAtividade = statusAtividade;
        this.validadeExtintor = validadeExtintor;
        this.modeloExtintor = modeloExtintor;
        this.seloInmetro = seloInmetro;
        this.pesoExtintor = pesoExtintor;
        this.anoExpecao = anoExpecao;
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


    public String getTamanhoMangueira() {
        return tamanhoMangueira;
    }

    public void setTamanhoMangueira(String tamanhoMangueira) {
        this.tamanhoMangueira = tamanhoMangueira;
    }

    public String getModeloMangueira() {
        return modeloMangueira;
    }

    public void setModeloMangueira(String modeloMangueira) {
        this.modeloMangueira = modeloMangueira;
    }

    public String getValidadeMangueira() {
        return validadeMangueira;
    }

    public void setValidadeMangueira(String validadeMangueira) {
        this.validadeMangueira = validadeMangueira;
    }

    public String getValidadeValvula() {
        return validadeValvula;
    }

    public void setValidadeValvula(String validadeValvula) {
        this.validadeValvula = validadeValvula;
    }

    public String getValidadeHidrante() {
        return validadeHidrante;
    }

    public void setValidadeHidrante(String validadeHidrante) {
        this.validadeHidrante = validadeHidrante;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public String getUltimoTeste() {
        return ultimoTeste;
    }

    public void setUltimoTeste(String ultimoTeste) {
        this.ultimoTeste = ultimoTeste;
    }

    public String getStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(String statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public String getValidadeExtintor() {
        return validadeExtintor;
    }

    public void setValidadeExtintor(String validadeExtintor) {
        this.validadeExtintor = validadeExtintor;
    }

    public String getModeloExtintor() {
        return modeloExtintor;
    }

    public void setModeloExtintor(String modeloExtintor) {
        this.modeloExtintor = modeloExtintor;
    }

    public String getSeloInmetro() {
        return seloInmetro;
    }

    public void setSeloInmetro(String seloInmetro) {
        this.seloInmetro = seloInmetro;
    }

    public String getPesoExtintor() {
        return pesoExtintor;
    }

    public void setPesoExtintor(String pesoExtintor) {
        this.pesoExtintor = pesoExtintor;
    }

    public String getAnoExpecao() {
        return anoExpecao;
    }

    public void setAnoExpecao(String anoExpecao) {
        this.anoExpecao = anoExpecao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    } 
    
}
