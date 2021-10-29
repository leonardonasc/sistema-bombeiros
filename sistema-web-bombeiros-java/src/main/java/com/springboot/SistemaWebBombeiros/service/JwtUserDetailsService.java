package com.springboot.sistemawebbombeiros.service;

import com.springboot.sistemawebbombeiros.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
        com.springboot.sistemawebbombeiros.models.Usuario user = usuarioRepository.findByMatricula(matricula);
        if (user.getMatricula().equals(matricula)) {
            return new User(matricula, user.getSenha(), true, true, true, true, user.getAuthorities(user));
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado com matricula: " + matricula);
        }
    }

    
}
