package com.salesianostriana.edu.romansdriving.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.repository.ClaseRepository;
import com.salesianostriana.edu.romansdriving.service.ClaseService;
import com.salesianostriana.edu.romansdriving.service.UsuarioService;

@Controller
//@RequestMapping("/Clases")
public class ClasesController {

	@Autowired
	private ClaseService clase;
	
	@Autowired
	private UsuarioService usuario;
	

	@GetMapping("/PlantillaClasesVehiculo")
	public String mostrarClasesDisponibles(Model model) {

		List<Clase> clasesNoOcupadas = clase.obtenerClasesNoOcupadas();

		model.addAttribute("clasesDisponibles", clasesNoOcupadas);
		model.addAttribute("precioConDescuento", usuario.calcularPrecioSiTieneCarnet());

		return "user/PlantillaClasesVehiculo";
	}

	
		

	
}
