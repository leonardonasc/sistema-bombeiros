package com.springboot.sistemawebbombeiros.repositories;
import com.springboot.sistemawebbombeiros.models.Morador;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MoradorRepository extends CrudRepository<Morador, Integer> {

    public List<Morador> findByNomeIgnoreCaseContaining(String nome);

    
}
