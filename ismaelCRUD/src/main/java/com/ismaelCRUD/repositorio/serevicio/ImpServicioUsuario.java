package com.ismaelCRUD.repositorio.serevicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismaelCRUD.entidades.Usuario;
import com.ismaelCRUD.repositorio.RepositorioUsuario;

@Service
public class ImpServicioUsuario implements ServicioUsuario{

	@Autowired
	RepositorioUsuario repository;
	
	@Override
	public Iterable<Usuario> getAllUsers() {
		
		return repository.findAll();
	}

}
