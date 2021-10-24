package com.springboot.SistemaWebBombeiros.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.springboot.SistemaWebBombeiros.Repositories.UsuarioRepository;
import com.springboot.SistemaWebBombeiros.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
        com.springboot.SistemaWebBombeiros.models.Usuario user = usuarioRepository.findByMatricula(matricula);
        if (user.getMatricula().equals(matricula)) {
            return new User(matricula, user.getSenha(), true, true, true, true, user.getAuthorities(user));
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado com matricula: " + matricula);
        }
    }

    
}
