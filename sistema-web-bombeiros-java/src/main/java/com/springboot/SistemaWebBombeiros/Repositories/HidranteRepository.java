package com.springboot.sistemawebbombeiros.repositories;
import com.springboot.sistemawebbombeiros.models.Hidrante;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HidranteRepository extends CrudRepository<Hidrante, Integer> {
    public List<Hidrante> findByEdificacao_Id(Integer id);
}
