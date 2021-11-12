package com.springboot.sistemawebbombeiros.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsuarioResponse {
    private Integer id;
    private String nome;
    private String matricula;
    private String nomeDeGuerra;
    private String email;
    private String perfilAcesso;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Integer id, String nome, String matricula, String nomeDeGuerra, String email,
                           String perfilAcesso) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.nomeDeGuerra = nomeDeGuerra;
        this.email = email;
        this.perfilAcesso = perfilAcesso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeDeGuerra() {
        return nomeDeGuerra;
    }

    public void setNomeDeGuerra(String nomeDeGuerra) {
        this.nomeDeGuerra = nomeDeGuerra;
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
