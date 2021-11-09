package com.springboot.sistemawebbombeiros.controllers;

import com.springboot.sistemawebbombeiros.models.Edificacao;
import com.springboot.sistemawebbombeiros.repositories.EdificacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("cadastros")
public class EdificacaoController {
    @Autowired
    private EdificacaoRepository repositorio;

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

    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody() Edificacao edificacao) {
        Edificacao edificacaoCriado = this.repositorio.save(edificacao);
        return new ResponseEntity<>(edificacaoCriado, HttpStatus.CREATED);
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
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody() Edificacao edificacao) {
        if (edificacao.getId() != null && id.equals(edificacao.getId())) {
            return ResponseEntity.ok(this.repositorio.save(edificacao));
        } else {
            return new ResponseEntity<>("Parâmetros inválidos", HttpStatus.BAD_REQUEST);
        }
    }
}
