package com.springboot.SistemaWebBombeiros.models;

public class Hidrante {
    private Number id;
    private String validade;
    private String numeroPatrimonio;
    private String dataUltimoTeste;
    private String statusAtividade;
    
    public Hidrante() {
    } 

    public Hidrante(Number id, String validade, String numeroPatrimonio, String dataUltimoTeste,
            String statusAtividade) {
        this.id = id;
        this.validade = validade;
        this.numeroPatrimonio = numeroPatrimonio;
        this.dataUltimoTeste = dataUltimoTeste;
        this.statusAtividade = statusAtividade;
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

}
