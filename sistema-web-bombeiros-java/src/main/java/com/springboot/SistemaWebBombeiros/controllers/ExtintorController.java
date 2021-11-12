package com.springboot.sistemawebbombeiros.controllers;

import com.springboot.sistemawebbombeiros.models.Extintor;
import com.springboot.sistemawebbombeiros.repositories.ExtintorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("extintores")
public class ExtintorController {
    @Autowired
    private ExtintorRepository repositorio;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.repositorio.findAll());
    }

    @GetMapping("/findByEdificacao/{id}")
    public ResponseEntity<?> findByEdificacao(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.repositorio.findByEdificacao_Id(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.repositorio.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody() Extintor extintor) {
        System.out.println(extintor.getEdificacao());
        Extintor extintorCriado = this.repositorio.save(extintor);
        return new ResponseEntity<>(extintorCriado, HttpStatus.CREATED);
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
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody() Extintor extintor) {
        if (extintor.getId() != null && id.equals(extintor.getId())) {
            return ResponseEntity.ok(this.repositorio.save(extintor));
        } else {
            return new ResponseEntity<>("Parâmetros inválidos", HttpStatus.BAD_REQUEST);
        }
    }

}
