package com.ismaelCRUD.servicio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ismaelCRUD.modelo.Usuario;
import com.ismaelCRUD.repositorio.RepositorioUsuario;


//creamos una clase para el login de usuario que implementa la interface de spring security UserDetailsService por lo tanto
//tenemos que implementar el metodo loadUserByUsername que cargara el usuario desde la base de datos.
@Service
@Transactional
public class LoginUsuario implements UserDetailsService{

	//requerimos el repositorio del usuario (la interface que creamos con  la extension de la clase de spring CrudRepository).
	
	@Autowired
	RepositorioUsuario repositorioUsuario;
	
	//metodo implementado de la interface UserDetailsService que carga el nombre de usuario de nuestra base de datos.
	@Override
	public UserDetails loadUserByUsername(String nombreusuario) throws UsernameNotFoundException {
		//guardamos en una variable el nombre del usuario de la base de datos cuando esta cargada la sesion el login lo hace por atras spring 
		//y lanzamos la excepcion por si el nombre de usuario no existe.
		Usuario cargarSesionUsuario = repositorioUsuario.findByUsername(nombreusuario).orElseThrow(() -> new UsernameNotFoundException("El Login Del Usuario Es Invalido."));
		
		//cargamos el usuario en la sesion gracias al objeto UserDetails de spring (guardamos en la sesiion el nombre de usuario(que nos lo da el metodo findByUsername)
		//y el password (al crear el objeto aplicacionusuario nos tare la password de ese usuario))
		UserDetails usuario = (UserDetails) new Usuario(nombreusuario,cargarSesionUsuario.getPassword());
		
		return usuario;
	}



	
}
