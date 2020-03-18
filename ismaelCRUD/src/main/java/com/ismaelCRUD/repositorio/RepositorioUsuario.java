package com.ismaelCRUD.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ismaelCRUD.entidades.Usuario;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Long>{
	public Optional findByUsername(String username);
}
