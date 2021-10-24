package com.springboot.SistemaWebBombeiros.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false)
    private String nome;
    @Column(unique=true)
    private String matricula;
    private String nomeDeGuerra;
    @Column(nullable=false)
    private String senha;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String perfilAcesso;
    
    public Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
        List<GrantedAuthority> authorities = new ArrayList();
        if (usuario.getPerfilAcesso().equals("Administrador")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorities.add(new SimpleGrantedAuthority("ROLE_MONITORAMENTO"));
            authorities.add(new SimpleGrantedAuthority("ROLE_COBOM"));
        } else if (usuario.getPerfilAcesso().equals("Monitoramento")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_MONITORAMENTO"));
        } else if (usuario.getPerfilAcesso().equals("Cobom")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_COBOM"));
        }

        return authorities;
    }

    public Usuario() {
    }

    public Usuario(int id, String nome, String matricula, String nomeDeGuerra, String senha, String email,
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
