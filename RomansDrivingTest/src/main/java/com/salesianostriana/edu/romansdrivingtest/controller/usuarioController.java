package com.salesianostriana.edu.romansdrivingtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.salesianostriana.edu.romansdrivingtest.services.UsuarioServices;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class usuarioController {

	@Autowired
	private UsuarioServices u;
	
	
	@GetMapping("/userAdmin")
	public String mostrarTabla(Model model) {
		
		model.addAttribute("listaUsuarios", u.mostrarListaUsuarios());
		return "index";
	}
}
