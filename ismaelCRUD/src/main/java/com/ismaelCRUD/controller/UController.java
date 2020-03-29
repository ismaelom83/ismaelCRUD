package com.ismaelCRUD.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ismaelCRUD.modelo.Usuario;
import com.ismaelCRUD.servicio.ServicioUsuario;

@Controller
public class UController {

	@Autowired
	ServicioUsuario servicioUsuario;

	@GetMapping({ "/", "index" })
	public String index() {
		return "index";
	}

	@GetMapping("/vista")
	public String getFormulario(Model modelo) {
		modelo.addAttribute("formulario", new Usuario());
		modelo.addAttribute("userList", servicioUsuario.getAllUsers());
		modelo.addAttribute("listTab", "active");
		return "formulario/vista";
	}

	@PostMapping("/formulario")
	public String crearUsuario(@Valid @ModelAttribute("formulario") Usuario usuario, BindingResult resultado,
			ModelMap modelo) {
		if (resultado.hasErrors()) {
			modelo.addAttribute("formulario", usuario);
			modelo.addAttribute("formTab", "active");
		} else {
			try {
				servicioUsuario.creacionUsuario(usuario);
				modelo.addAttribute("formulario", new Usuario());
				modelo.addAttribute("listTab", "active");
			} catch (Exception e) {
				modelo.addAttribute("mensajeError",e.getMessage());
				modelo.addAttribute("formulario", usuario);
				modelo.addAttribute("formTab", "active");
				modelo.addAttribute("userList", servicioUsuario.getAllUsers());
			}
		}
		modelo.addAttribute("userList", servicioUsuario.getAllUsers());
		return "formulario/vista";

	}
}
