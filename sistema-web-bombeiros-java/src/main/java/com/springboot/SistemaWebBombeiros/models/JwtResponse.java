package com.springboot.sistemawebbombeiros.models;

public class JwtResponse {
    private final String jwttoken;
    private Usuario usuario;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public JwtResponse(String jwttoken, Usuario usuario) {
        this.jwttoken = jwttoken;
        this.usuario = usuario;
    }

    public String getJwttoken() {
        return jwttoken;
    }
    
}
