package com.springboot.sistemawebbombeiros.controllers;

import java.util.Optional;

import com.springboot.sistemawebbombeiros.models.Usuario;
import com.springboot.sistemawebbombeiros.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repositorio;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.repositorio.findAll());
    }
    @GetMapping("findByNome/{nome}")
    public ResponseEntity<?> listByNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(this.repositorio.findByNomeIgnoreCaseContaining(nome));
    }
    @GetMapping("findByEmail/{email}")
    public ResponseEntity<?> listByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(this.repositorio.findByEmailIgnoreCaseContaining(email));
    }
    @GetMapping("/:id")
    public ResponseEntity<?> read(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.repositorio.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody() Usuario usuario) {
        String password = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt(12));
        usuario.setSenha(password);
        Usuario usuarioCriado = this.repositorio.save(usuario);
        return new ResponseEntity<>(usuarioCriado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            this.repositorio.deleteById(id);
        } 
        finally {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }    

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody() Usuario usuario) {
        if (usuario.getId() != null && id.equals(usuario.getId())) {
            String password = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt(12));
            usuario.setSenha(password);
            return ResponseEntity.ok(this.repositorio.save(usuario));
        } else {
            return new ResponseEntity<>("Parâmetros inválidos", HttpStatus.BAD_REQUEST);
        }
    }
}
