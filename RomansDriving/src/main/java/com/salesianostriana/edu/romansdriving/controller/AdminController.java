package com.salesianostriana.edu.romansdriving.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.edu.romansdriving.model.Admin;
import com.salesianostriana.edu.romansdriving.model.Cliente;
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

	@PostMapping("/guardarPersona/submit")
	public String guardarPersona(@ModelAttribute Usuario usuario, Model model) {
		u.save(usuario);

		model.addAttribute("listaUsuarios", u.findAll());
		return "redirect:/gestionUsuarios";

	}

	@GetMapping("/editUsuario/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
		Optional<Usuario> aEditar = u.findById(id);

        if (aEditar.isPresent()) {
            model.addAttribute("usuario", aEditar.get());
            return "admin/formulario";
        }

        else {
            return "redirect:/gestionUsuarios";
        }

    }


    @PostMapping("/editUsuario/submit")
    public String editarUsuario(@ModelAttribute("usuario")Usuario usuario) {

        u.save(usuario);

        return "redirect:/gestionUsuarios";
    }
	
    @GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		u.deleteById(id);
		return "redirect:/gestionUsuarios";
	}
	
}
