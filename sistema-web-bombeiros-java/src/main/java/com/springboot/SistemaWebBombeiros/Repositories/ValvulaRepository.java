package com.springboot.sistemawebbombeiros.repositories;
import com.springboot.sistemawebbombeiros.models.Valvula;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValvulaRepository extends CrudRepository<Valvula, Integer> {

    public List<Valvula> findByEdificacao_Id(Integer id);
}
