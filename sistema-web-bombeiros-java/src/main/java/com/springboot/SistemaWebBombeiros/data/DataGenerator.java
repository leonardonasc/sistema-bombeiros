package com.springboot.sistemawebbombeiros.data;

import com.springboot.sistemawebbombeiros.models.Usuario;
import com.springboot.sistemawebbombeiros.repositories.UsuarioRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator {
    @Bean
    public CommandLineRunner loadData(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository) {

        System.out.println("test ok");
        return args -> {
            if (usuarioRepository.count() == 0) {
                Usuario usuario = new Usuario();
                usuario.setNome("Noah Caua Felipe Mathias");
                usuario.setMatricula("70213");
                usuario.setSenha(passwordEncoder.encode("admin"));
                usuario.setEmail("noah.rocha@bombeiros.sc.com.br");
                usuario.setPerfilAcesso("ADMINISTRADOR");
                usuarioRepository.save(usuario);
                System.out.println("Id usuario: " + usuario.getId());
            }

        };

    }
}
