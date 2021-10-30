package com.springboot.sistemawebbombeiros.models;

import javax.persistence.*;

@Entity
public class Hidrante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false)
    private String validade;
    private String numeroPatrimonio;
    @Column(nullable=false)
    private String dataUltimoTeste;
    private String statusAtividade;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Edificacao edificacao;
    
    public Hidrante() {
    } 

    public Hidrante(Integer id, String validade, String numeroPatrimonio, String dataUltimoTeste, String statusAtividade,
            Edificacao edificacao) {
        this.id = id;
        this.validade = validade;
        this.numeroPatrimonio = numeroPatrimonio;
        this.dataUltimoTeste = dataUltimoTeste;
        this.statusAtividade = statusAtividade;
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
    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }
    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }
    public String getDataUltimoTeste() {
        return dataUltimoTeste;
    }
    public void setDataUltimoTeste(String dataUltimoTeste) {
        this.dataUltimoTeste = dataUltimoTeste;
    }
    public String getStatusAtividade() {
        return statusAtividade;
    }
    public void setStatusAtividade(String statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public Edificacao getEdificacao() {
        return edificacao;
    }

    public void setEdificacao(Edificacao edificacao) {
        this.edificacao = edificacao;
    }


}
