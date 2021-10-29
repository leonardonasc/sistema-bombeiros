package com.springboot.sistemawebbombeiros.repositories;
import java.util.List;

import com.springboot.sistemawebbombeiros.models.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
    public Usuario findByMatricula(@Param("matricula")String matricula);
    public List<Usuario> findByNomeIgnoreCaseContaining(String nome);
    public List<Usuario> findByEmailIgnoreCaseContaining(String email);
    public List<Usuario> findByPerfilAcesso(String perfilAcesso);
    
}
