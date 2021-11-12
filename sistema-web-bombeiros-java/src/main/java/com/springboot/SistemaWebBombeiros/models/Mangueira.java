package com.springboot.sistemawebbombeiros.models;

import javax.persistence.*;

@Entity
public class Mangueira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modelo;
    @Column(nullable=false)
    private String validade;
    private String tamanho;    
    @ManyToOne
    @JoinColumn(nullable=false)
    private Edificacao edificacao;
    
    public Mangueira() {
    }   

    public Mangueira(Integer id, String modelo, String validade, String tamanho, Edificacao edificacao) {
        this.id = id;
        this.modelo = modelo;
        this.validade = validade;
        this.tamanho = tamanho;
        this.edificacao = edificacao;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getValidade() {
        return validade;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Edificacao getEdificacao() {
        return edificacao;
    }

    public void setEdificacao(Edificacao edificacao) {
        this.edificacao = edificacao;
    }

    
}
