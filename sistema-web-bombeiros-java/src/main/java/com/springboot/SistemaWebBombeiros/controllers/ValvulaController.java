package com.springboot.sistemawebbombeiros.controllers;

import com.springboot.sistemawebbombeiros.models.Valvula;
import com.springboot.sistemawebbombeiros.repositories.ValvulaRepository;

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
@RequestMapping("valvulas")
public class ValvulaController {
    @Autowired
    private ValvulaRepository repositorio;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.repositorio.findAll());
    }
    @GetMapping("/:id")
    public ResponseEntity<?> read(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.repositorio.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody() Valvula valvula) {
        Valvula usuarioCriado = this.repositorio.save(valvula);
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
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody() Valvula valvula) {
        if (valvula.getId() != null && id.equals(valvula.getId())) {
            return ResponseEntity.ok(this.repositorio.save(valvula));
        } else {
            return new ResponseEntity<>("Parâmetros inválidos", HttpStatus.BAD_REQUEST);
        }
    }
}
