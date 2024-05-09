package com.salesianostriana.edu.romansdriving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String index() {
        return "user/principal";
    }

    @GetMapping("/mostrarPlantillaVehiculo")
    public String mostrarPlantillaVehiculo(Model model) {
    	
    	model.addAttribute("prueba", null);
    	return "/plantillaVehiculo";
    }
    
   
    
}
