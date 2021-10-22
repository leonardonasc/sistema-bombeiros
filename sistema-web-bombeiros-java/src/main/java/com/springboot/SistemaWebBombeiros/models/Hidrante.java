package com.springboot.SistemaWebBombeiros.models;

import javax.persistence.*;

@Entity
public class Hidrante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String validade;
    private String numeroPatrimonio;
    private String dataUltimoTeste;
    private String statusAtividade;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Morador morador;
    
    public Hidrante() {
    } 

    public Hidrante(int id, String validade, String numeroPatrimonio, String dataUltimoTeste, String statusAtividade,
            Morador morador) {
        this.id = id;
        this.validade = validade;
        this.numeroPatrimonio = numeroPatrimonio;
        this.dataUltimoTeste = dataUltimoTeste;
        this.statusAtividade = statusAtividade;
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

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }


}
