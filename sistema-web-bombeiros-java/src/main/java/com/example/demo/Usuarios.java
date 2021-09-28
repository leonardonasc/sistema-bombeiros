package com.example.demo;

public class Usuarios {
    private String nome;
    private String matricula;
    private String nomeDeGuerra;
    private String senha;
    private String email;
    private PerfilAcesso perfilAcesso;
	
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
	public PerfilAcesso getPerfilAcesso() {
		return perfilAcesso;
	}
	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}
    
}

enum PerfilAcesso {
    Administrador, Cobom, Monitoramento;
}
