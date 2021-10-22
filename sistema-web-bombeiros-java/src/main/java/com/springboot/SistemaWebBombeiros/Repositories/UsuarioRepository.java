package com.springboot.SistemaWebBombeiros.Repositories;
import com.springboot.SistemaWebBombeiros.models.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
}
