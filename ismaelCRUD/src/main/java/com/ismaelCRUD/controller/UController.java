package com.ismaelCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ismaelCRUD.entidades.Usuario;
import com.ismaelCRUD.repositorio.serevicio.ServicioUsuario;

@Controller
public class UController {
	
	@Autowired 
	ServicioUsuario servicioUsuario;

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/vista")
	public String getFormulario(Model model) {
		model.addAttribute("formulario", new Usuario());
		model.addAttribute("userList", servicioUsuario.getAllUsers());
		model.addAttribute("listTab","active");
		return "formulario/vista";
	}
	
}






