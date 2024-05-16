package com.salesianostriana.edu.romansdriving.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.TipoVehiculo;
import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.service.ClaseService;
import com.salesianostriana.edu.romansdriving.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;

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
		// Actualizar las clases fuera de plazo antes de mostrar las clases disponibles
		clase.actualizarClasesFueraPlazo();

		// Obtener las clases disponibles
		List<Clase> clasesDisponibles = clase.obtenerClasesMasRecientesNoOcupadas();

		model.addAttribute("clasesDisponibles", clasesDisponibles);
		return "user/PlantillaClasesVehiculo";
	}

	@GetMapping("/PlantillaClasesCoche")
	public String mostrarClasesDisponiblesCoche(Model model) {
		TipoVehiculo tipo = (TipoVehiculo.coche);

		List<Clase> clasesCocheDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
		model.addAttribute("clasesDisponibles", clasesCocheDisponibles);
		return "user/PlantillaClasesVehiculo";

	}
	
	@GetMapping("/PlantillaClasesMoto")
	public String mostrarClasesDisponiblesMoto(Model model) {
		TipoVehiculo tipo = (TipoVehiculo.moto);

		List<Clase> clasesMotoDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
		model.addAttribute("clasesDisponibles", clasesMotoDisponibles);
		return "user/PlantillaClasesVehiculo";

	}

	@GetMapping("/PlantillaClasesCamion")
	public String mostrarClasesDisponiblesCamion(Model model) {
		TipoVehiculo tipo = (TipoVehiculo.camión);

		List<Clase> clasesCamionDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
		model.addAttribute("clasesDisponibles", clasesCamionDisponibles);
		return "user/PlantillaClasesVehiculo";

	}

	@GetMapping("/precioClase/{id}")
	public String mostrarPrecioClase(@PathVariable("id") Long id, Model model) {
		List<Usuario> precioClase = usuario.calcularPrecioSiTieneCarnet(id);
		model.addAttribute("precioClase", precioClase);
		return "user/PlantillaClasesVehiculo";
	}


	@GetMapping("/reservarClase/{id}")
	public String hacerReservaClase(@AuthenticationPrincipal Usuario usuario, @PathVariable("id") Long id, Model model) {
		
		if(clase.anhadirClaseUsuario(usuario, id)) {
			model.addAttribute("atributo", clase.anhadirClaseUsuario(usuario, id));
			return "user/reservaClase";
		}
		else {
			return "error";
		}
		

		
	}

	@PostMapping("/reservarClase/submit")
	public String reserva(@ModelAttribute ("reservarClase")Clase clasee){

		clase.edit(clasee);
		return "redirect:/PlantillaClasesVehiculo";
	}

}