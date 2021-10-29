package com.springboot.sistemawebbombeiros.models;

import javax.persistence.*;

@Entity
public class Valvula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false)
    private String validade;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Morador morador;
    
    public Valvula() {
    }
   
    public Valvula(Integer id, String validade, Morador morador) {
        this.id = id;
        this.validade = validade;
        this.morador = morador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }
    
    
}
