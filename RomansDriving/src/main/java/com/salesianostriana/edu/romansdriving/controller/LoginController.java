package com.salesianostriana.edu.romansdriving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private UsuarioService usuario;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	 @GetMapping("/login")
		public String login() {
			return "login";
		}	
	 
		@GetMapping("/register/")
		public String formularioGuardar(Model model, Usuario user) {
			
			
			model.addAttribute("registro", new Usuario());
			return "register";
			
			/*en el html de register tengo que poner un bloque se s */
		}
		
		@PostMapping("/formularioRegistro/submit")
		public String guardarUsuario(@ModelAttribute("registro") Usuario user , Model model) {
			
			if(usuario.usuarioConFechaIncorrecta(user)) {
				String encodedPassword = passwordEncoder.encode(user.getPassword());
				user.setPassword(encodedPassword);
				usuario.save(user);
				
				model.addAttribute("usuario", usuario);
			    return "redirect:/login"; 
			}
			else {
				return "redirect:/register/?error=true";
			}
			
		    
		    // else {return "redirect:/register/?error=true"}
		}
}
