package com.springboot.sistemawebbombeiros.controllers;

import com.springboot.sistemawebbombeiros.models.Morador;
import com.springboot.sistemawebbombeiros.repositories.MoradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("moradores")
public class MoradorController {
    @Autowired
    private MoradorRepository repositorio;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.repositorio.findAll());
    }
    @GetMapping("findByNome/{nome}")
    public ResponseEntity<?> listByNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(this.repositorio.findByNomeIgnoreCaseContaining(nome));
    }
    @GetMapping("/:id")
    public ResponseEntity<?> read(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.repositorio.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody() Morador morador) {
        Morador usuarioCriado = this.repositorio.save(morador);
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
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody() Morador morador) {
        if (morador.getId() != null && id.equals(morador.getId())) {
            return ResponseEntity.ok(this.repositorio.save(morador));
        } else {
            return new ResponseEntity<>("Parâmetros inválidos", HttpStatus.BAD_REQUEST);
        }
    }
}
