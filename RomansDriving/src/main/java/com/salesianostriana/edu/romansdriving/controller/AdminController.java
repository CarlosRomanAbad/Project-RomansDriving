package com.salesianostriana.edu.romansdriving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.service.UsuarioService;

@Controller
public class AdminController {

	@Autowired
	private UsuarioService u;


	@GetMapping("/gestionUsuarios")
	public String mostrarLista(Model model) {
		model.addAttribute("listaUsuarios", u.findAll());
		return "admin/gestionUsuarios";
	}

	@GetMapping("/formulario")
	public String mostrarFormulario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "admin/formulario";
	}

	@PostMapping("/guardarPersona")
	public String guardarPersona(@ModelAttribute Usuario usuario, Model model) {
		u.save(usuario);

		model.addAttribute("listaUsuarios", u.findAll());
		return "redirect:/gestionUsuarios";

	}

}
