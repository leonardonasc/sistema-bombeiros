package com.springboot.sistemawebbombeiros.models;

import javax.persistence.*;
@Entity
public class Extintor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false)
    private String dataValidade;
    @Column(nullable=false)
    private String modelo;
    private String seloInmetro;
    private String peso;
    private String anoInspecao;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Morador morador;
    
    public Extintor() {
    }
    
    public Extintor(Integer id, String dataValidade, String modelo, String seloInmetro, String peso, String anoInspecao,
            Morador morador) {
        this.id = id;
        this.dataValidade = dataValidade;
        this.modelo = modelo;
        this.seloInmetro = seloInmetro;
        this.peso = peso;
        this.anoInspecao = anoInspecao;
        this.morador = morador;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }
}
