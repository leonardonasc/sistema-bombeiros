package com.springboot.sistemawebbombeiros.repositories;
import com.springboot.sistemawebbombeiros.models.Mangueira;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangueiraRepository extends CrudRepository<Mangueira, Integer>{

    public List<Mangueira> findByEdificacao_Id(Integer id);
}
