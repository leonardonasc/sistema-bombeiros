package com.springboot.sistemawebbombeiros.repositories;
import com.springboot.sistemawebbombeiros.models.Edificacao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EdificacaoRepository extends CrudRepository<Edificacao, Integer> {

    public List<Edificacao> findByNomeIgnoreCaseContaining(String nome);

    
}
