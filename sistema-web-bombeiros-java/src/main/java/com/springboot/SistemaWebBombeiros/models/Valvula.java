package com.springboot.SistemaWebBombeiros.models;

public class Valvula {
    private Number id;
    private String validade;
    
    public Valvula() {
    }

    public Valvula(Number id, String validade) {
        this.id = id;
        this.validade = validade;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
    
    
}
