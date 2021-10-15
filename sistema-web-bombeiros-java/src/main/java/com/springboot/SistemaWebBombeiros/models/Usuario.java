package com.springboot.SistemaWebBombeiros.models;

public class Usuario {
    private Number id;
    private String nome;
    private Number matricula;
    private String nomeDeGuerra;
    private String senha;
    private String email;
    private String perfilAcesso;
    
    public Usuario() {
    }

    public Usuario(Number id, String nome, Number matricula, String nomeDeGuerra, String senha, String email,
            String perfilAcesso) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.nomeDeGuerra = nomeDeGuerra;
        this.senha = senha;
        this.email = email;
        this.perfilAcesso = perfilAcesso;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Number getMatricula() {
        return matricula;
    }

    public void setMatricula(Number matricula) {
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
