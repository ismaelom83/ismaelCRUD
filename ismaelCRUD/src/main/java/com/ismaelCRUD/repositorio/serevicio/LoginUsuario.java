package com.ismaelCRUD.repositorio.serevicio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.ismaelCRUD.entidades.Usuario;
import com.ismaelCRUD.repositorio.RepositorioUsuario;

@Service
@Transactional
public class LoginUsuario implements UserDetailsService {

	@Autowired
	RepositorioUsuario repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
		
//		com.ismaelCRUD.entidades.Usuario appUser = repositorio.findByUsername(username);
//		
//		UserDetails user = (UserDetails) new Usuario(appUser.getNombreusuario(), appUser.getPassword());
//		return null;
	}

	
}
