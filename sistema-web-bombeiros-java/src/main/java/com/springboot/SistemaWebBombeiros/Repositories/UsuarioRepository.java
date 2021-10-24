package com.springboot.SistemaWebBombeiros.Repositories;
import com.springboot.SistemaWebBombeiros.models.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    public Usuario findByMatricula(@Param("matricula")String matricula);
    
}
