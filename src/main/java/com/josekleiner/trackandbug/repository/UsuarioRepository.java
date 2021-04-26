package com.josekleiner.trackandbug.repository;

import org.springframework.data.repository.CrudRepository;

import com.josekleiner.trackandbug.bo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
