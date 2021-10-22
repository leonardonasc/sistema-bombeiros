package com.springboot.SistemaWebBombeiros.Repositories;
import com.springboot.SistemaWebBombeiros.models.Morador;

import org.springframework.data.repository.CrudRepository;

public interface MoradorRepository extends CrudRepository<Morador, Integer> {
    
}
