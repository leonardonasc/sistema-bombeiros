package com.springboot.SistemaWebBombeiros.models;

public class Mangueira {
    private Number id;
    private String modelo;
    private String validade;
    private String tamanho;    
    
    public Mangueira() {
    }   

    public Mangueira(Number id, String modelo, String validade, String tamanho) {
        this.id = id;
        this.modelo = modelo;
        this.validade = validade;
        this.tamanho = tamanho;
    }

    public Number getId() {
        return id;
    }
    public void setId(Number id) {
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

    
}
