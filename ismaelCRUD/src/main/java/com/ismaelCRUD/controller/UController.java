package com.ismaelCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/formulario")
	public String getFormulario() {
		return "formulario";
	}
}
