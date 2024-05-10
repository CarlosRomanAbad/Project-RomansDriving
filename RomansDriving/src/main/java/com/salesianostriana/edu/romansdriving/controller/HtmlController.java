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

    @GetMapping("/PlantillaClasesVehiculo")
    public String mostrarPlantillaVehiculo(Model model) {
    	return "user/PlantillaClasesVehiculo";
    }
    
   
    
}
