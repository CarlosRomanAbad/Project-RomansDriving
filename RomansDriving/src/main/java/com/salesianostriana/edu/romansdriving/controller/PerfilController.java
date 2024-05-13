package com.salesianostriana.edu.romansdriving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.service.UsuarioService;

@Controller
public class PerfilController {

    @Autowired
    private UsuarioService usuario;

    @GetMapping("/mostrarPerfil")
    public String mostrarPerfil(@AuthenticationPrincipal Usuario usuario, Model model) {

        model.addAttribute("perfil", usuario);

        return "user/miPerfil";

    }
}