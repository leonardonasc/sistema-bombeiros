package com.springboot.sistemawebbombeiros.models;

public class ValidadeEdificacoes {
    private Extintor extintor;
    private Hidrante hidrante;
    private Mangueira mangueira;
    private Valvula valvula;

    public ValidadeEdificacoes() {

    }

    public ValidadeEdificacoes(Extintor extintor, Hidrante hidrante, Mangueira mangueira, Valvula valvula) {
        this.extintor = extintor;
        this.hidrante = hidrante;
        this.mangueira = mangueira;
        this.valvula = valvula;
    }

    public Extintor getExtintor() {
        return extintor;
    }

    public void setExtintor(Extintor extintor) {
        this.extintor = extintor;
    }

    public Hidrante getHidrante() {
        return hidrante;
    }

    public void setHidrante(Hidrante hidrante) {
        this.hidrante = hidrante;
    }

    public Mangueira getMangueira() {
        return mangueira;
    }

    public void setMangueira(Mangueira mangueira) {
        this.mangueira = mangueira;
    }

    public Valvula getValvula() {
        return valvula;
    }

    public void setValvula(Valvula valvula) {
        this.valvula = valvula;
    }
}
