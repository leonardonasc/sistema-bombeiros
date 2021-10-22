package com.springboot.SistemaWebBombeiros.Repositories;
import com.springboot.SistemaWebBombeiros.models.Extintor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtintorRepository extends CrudRepository<Extintor, Integer> {

}


