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
    private Edificacao edificacao;
    
    public Valvula() {
    }
   
    public Valvula(Integer id, String validade, Edificacao edificacao) {
        this.id = id;
        this.validade = validade;
        this.edificacao = edificacao;
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

    public Edificacao getEdificacao() {
        return edificacao;
    }

    public void setEdificacao(Edificacao edificacao) {
        this.edificacao = edificacao;
    }
    
    
}
