package com.springboot.sistemawebbombeiros.controllers;

import com.springboot.sistemawebbombeiros.models.*;
import com.springboot.sistemawebbombeiros.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("relatorios")
public class ValidadeEdificacoesController {

    @Autowired
    private EdificacaoRepository repositorioEdificacao;

    @Autowired
    private ExtintorRepository repositorioExtintor;

    @Autowired
    private HidranteRepository repositorioHidrante;

    @Autowired
    private MangueiraRepository repositorioMangueira;

    @Autowired
    private ValvulaRepository repositorioValvula;

    @GetMapping
    private List<ValidadeEdificacoes> getValidadeEdificacoes() {
        ArrayList<ValidadeEdificacoes> validadeEdificacoes = new ArrayList<>();

        Iterable<Edificacao> edificacoes = repositorioEdificacao.findAll();
        for (Iterator<Edificacao> it = edificacoes.iterator(); it.hasNext(); ) {
            Edificacao edificacao = it.next();
            Extintor extintor = repositorioExtintor.findFirstByEdificacao(edificacao);
            Hidrante hidrante = repositorioHidrante.findFirstByEdificacao(edificacao);
            Mangueira mangueira = repositorioMangueira.findFirstByEdificacao(edificacao);
            Valvula valvula = repositorioValvula.findFirstByEdificacao(edificacao);


            ValidadeEdificacoes validadeEdificacoes1 = new ValidadeEdificacoes();
            validadeEdificacoes1.setExtintor(extintor);
            validadeEdificacoes1.setValvula(valvula);
            validadeEdificacoes1.setHidrante(hidrante);
            validadeEdificacoes1.setMangueira(mangueira);

            validadeEdificacoes.add(validadeEdificacoes1);
        }

        return  validadeEdificacoes;

    }
}
