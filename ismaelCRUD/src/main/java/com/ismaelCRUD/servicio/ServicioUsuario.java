package com.ismaelCRUD.servicio;

import com.ismaelCRUD.modelo.Usuario;

public interface ServicioUsuario {
	
	public Iterable<Usuario> getAllUsers();
}
