package com.springboot.sistemawebbombeiros.repositories;
import java.util.List;

import com.springboot.sistemawebbombeiros.models.Edificacao;
import com.springboot.sistemawebbombeiros.models.Extintor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExtintorRepository extends CrudRepository<Extintor, Integer> {
    
    public List<Extintor> findByDataValidade(String dataValidade); 
    // public List<Extintor> findByDataValidadeBetween(Date dataDeValidadeInicial, Date dataDeValidadeFinal);
    public List<Extintor> findByModelo(String modelo);
    public List<Extintor> findByAnoInspecao(String anoInspecao);
    public List<Extintor> findByEdificacao_Id(Integer id);
    public List<Extintor> findByEdificacao(Edificacao edificacao);

    public Extintor findFirstByEdificacao(Edificacao edificacao);

}


