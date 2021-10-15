package com.springboot.SistemaWebBombeiros.models;

public class Extintor {
    private Number id;
    private String dataValidade;
    private String modelo;
    private String seloInmetro;
    private String peso;
    private String anoInspecao;
    
    public Extintor() {
    }
    
    public Extintor(Number id, String dataValidade, String modelo, String seloInmetro, String peso,
            String anoInspecao) {
        this.id = id;
        this.dataValidade = dataValidade;
        this.modelo = modelo;
        this.seloInmetro = seloInmetro;
        this.peso = peso;
        this.anoInspecao = anoInspecao;
    }
    
    public Number getId() {
        return id;
    }
    public void setId(Number id) {
        this.id = id;
    }
    public String getDataValidade() {
        return dataValidade;
    }
    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getSeloInmetro() {
        return seloInmetro;
    }
    public void setSeloInmetro(String seloInmetro) {
        this.seloInmetro = seloInmetro;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getAnoInspecao() {
        return anoInspecao;
    }
    public void setAnoInspecao(String anoInspecao) {
        this.anoInspecao = anoInspecao;
    }

    
}
