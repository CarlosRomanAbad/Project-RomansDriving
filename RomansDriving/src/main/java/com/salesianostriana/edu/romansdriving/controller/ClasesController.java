package com.salesianostriana.edu.romansdriving.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.service.ClaseService;
import com.salesianostriana.edu.romansdriving.service.UsuarioService;

@Controller
// @RequestMapping("/Clases")
public class ClasesController {

	@Autowired
	private ClaseService clase;

	@Autowired
	private UsuarioService usuario;

	@GetMapping("/reserva/{id}")
	public String mostrarReservaSeleccionada(@PathVariable("id") Long id, Model model) {
	    Optional<Clase> optionalClase = clase.findById(id);
	    
	    if (optionalClase.isPresent()) {
	        Clase claseSeleccionada = optionalClase.get();
	        model.addAttribute("reserva", claseSeleccionada); 
	        return "user/reservaClase";
	    } else {
	       
	        return "redirect:/error";
	    }
	}

	@GetMapping("/PlantillaClasesVehiculo")
	public String mostrarClasesDisponibles(Model model) {

		List<Clase> clasesNoOcupadas = clase.obtenerClasesNoOcupadas();

		

		model.addAttribute("clasesDisponibles", clasesNoOcupadas);

		return "user/PlantillaClasesVehiculo";
	}

	@GetMapping("/precioClase/{id}")
	public String mostrarPrecioClase(@PathVariable("id") Long id, Model model) {
		List<Usuario> precioClase = usuario.calcularPrecioSiTieneCarnet(id);
		model.addAttribute("precioClase", precioClase);
		return "user/PlantillaClasesVehiculo";
	}

	

	
}