package com.springboot.SistemaWebBombeiros.models;

import javax.persistence.*;

@Entity
public class Mangueira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String modelo;
    private String validade;
    private String tamanho;    
    @ManyToOne
    @JoinColumn(nullable=false)
    private Morador morador;
    
    public Mangueira() {
    }   

    public Mangueira(int id, String modelo, String validade, String tamanho, Morador morador) {
        this.id = id;
        this.modelo = modelo;
        this.validade = validade;
        this.tamanho = tamanho;
        this.morador = morador;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
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

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    
}
