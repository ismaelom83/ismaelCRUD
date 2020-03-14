package com.ismaelCRUD.repositorio.serevicio;

import com.ismaelCRUD.entidades.Usuario;

public interface ServicioUsuario {
	
	public Iterable<Usuario> getAllUsers();
}
