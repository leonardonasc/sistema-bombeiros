package com.springboot.sistemawebbombeiros.controllers;

import com.springboot.sistemawebbombeiros.models.Mangueira;
import com.springboot.sistemawebbombeiros.repositories.MangueiraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("mangueiras")
public class MangueiraController {
    @Autowired
    private MangueiraRepository repositorio;

    @GetMapping("/findByEdificacao/{id}")
    public ResponseEntity<?> findByEdificacao(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.repositorio.findByEdificacao_Id(id));
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.repositorio.findAll());
    }

    @GetMapping("/:id")
    public ResponseEntity<?> read(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.repositorio.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody() Mangueira mangueira) {
        Mangueira usuarioCriado = this.repositorio.save(mangueira);
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
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody() Mangueira mangueira) {
        if (mangueira.getId() != null && id.equals(mangueira.getId())) {
            return ResponseEntity.ok(this.repositorio.save(mangueira));
        } else {
            return new ResponseEntity<>("Parâmetros inválidos", HttpStatus.BAD_REQUEST);
        }
    }
}
