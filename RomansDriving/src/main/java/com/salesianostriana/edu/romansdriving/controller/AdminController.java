package com.salesianostriana.edu.romansdriving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.edu.romansdriving.service.UsuarioService;

@Controller
public class AdminController {
    
    @Autowired
    private UsuarioService u;

    @GetMapping("/gestionUsuarios")
    public String mostrarLista(Model model){
        model.addAttribute("listaUsuarios", u.getUsuarios());
        return "admin/gestionUsuarios";
    }
}
