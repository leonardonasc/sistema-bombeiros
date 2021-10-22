package com.springboot.SistemaWebBombeiros.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false)
    private String nome;
    @Column(unique=true)
    private int matricula;
    private String nomeDeGuerra;
    @Column(nullable=false)
    private String senha;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String perfilAcesso;
    
    public Usuario() {
    }

    public Usuario(int id, String nome, int matricula, String nomeDeGuerra, String senha, String email,
            String perfilAcesso) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.nomeDeGuerra = nomeDeGuerra;
        this.senha = senha;
        this.email = email;
        this.perfilAcesso = perfilAcesso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNomeDeGuerra() {
        return nomeDeGuerra;
    }

    public void setNomeDeGuerra(String nomeDeGuerra) {
        this.nomeDeGuerra = nomeDeGuerra;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(String perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }


}
