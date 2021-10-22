package com.springboot.SistemaWebBombeiros.models;

import javax.persistence.*;

@Entity
public class Valvula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false)
    private String validade;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Morador morador;
    
    public Valvula() {
    }
   
    public Valvula(int id, String validade, Morador morador) {
        this.id = id;
        this.validade = validade;
        this.morador = morador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
