package com.salesianostriana.edu.romansdriving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private UsuarioService usuario;
	
	 @GetMapping("/login")
		public String login() {
			return "login";
		}	
	 
		@GetMapping("/register")
		public String formularioGuardar(Model model) {
			
			
			model.addAttribute("registro", new Usuario());
			return "register";
		}
		
		@PostMapping("/formularioRegistro/submit")
		public String guardarUsuario(Usuario user) {
		    usuario.save(user);
		    return "redirect:/login"; // Reemplaza "ruta/a/html-esperado" con la ruta adecuada
		}
}
