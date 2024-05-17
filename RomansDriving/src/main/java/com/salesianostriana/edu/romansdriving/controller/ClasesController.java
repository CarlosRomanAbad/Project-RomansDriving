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
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.TipoVehiculo;
import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.service.ClaseService;
import com.salesianostriana.edu.romansdriving.service.ProfesorService;
import com.salesianostriana.edu.romansdriving.service.UsuarioService;
import com.salesianostriana.edu.romansdriving.service.VehiculoService;

@Controller
// @RequestMapping("/Clases")
public class ClasesController {

	@Autowired
	private ClaseService clase;

	@Autowired
	private UsuarioService usuario;
	
	@Autowired
	private ProfesorService profesor;
	
	@Autowired
	private VehiculoService vehiculo;

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
	
	@GetMapping("/reserva/{id}/confirmar")
	public String confirmarReserva(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal Usuario usuario) {

		if (clase.anhadirClaseUsuario(usuario, id)) {
			return "redirect:/PlantillaClasesVehiculo";
		}
		else {
			return "error";
		}
	}

	@GetMapping("/PlantillaClasesVehiculo")
	public String mostrarClasesDisponibles(Model model, Usuario user) {

		clase.actualizarClasesFueraPlazo();
		Double precioNuevo = 0.0;

		List<Clase> clasesDisponibles = clase.obtenerClasesMasRecientesNoOcupadas();
		List<Clase> clasesAlumnosConCarnet = clase.obtenerClasesDeAlumnoConCarnet();

		if (!clasesAlumnosConCarnet.isEmpty()) {
			precioNuevo = clase.cambiarPrecioClases();
			model.addAttribute("precioNuevo", precioNuevo);
		}

		model.addAttribute("clasesDisponibles", clasesDisponibles);

		return "user/PlantillaClasesVehiculo";
	}

	@GetMapping("/PlantillaClasesCoche")
	public String mostrarClasesDisponiblesCoche(Model model) {
		TipoVehiculo tipo = (TipoVehiculo.coche);
		double precioNuevo = clase.cambiarPrecioClases();

		List<Clase> clasesCocheDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
		model.addAttribute("clasesDisponibles", clasesCocheDisponibles);
		model.addAttribute("precioNuevo", precioNuevo);
		return "user/PlantillaClasesVehiculo";

	}

	@GetMapping("/PlantillaClasesMoto")
	public String mostrarClasesDisponiblesMoto(Model model) {
		TipoVehiculo tipo = (TipoVehiculo.moto);
		double precioNuevo = clase.cambiarPrecioClases();

		List<Clase> clasesMotoDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
		model.addAttribute("clasesDisponibles", clasesMotoDisponibles);
		model.addAttribute("precioNuevo", precioNuevo);
		return "user/PlantillaClasesVehiculo";

	}

	@GetMapping("/PlantillaClasesCamion")
	public String mostrarClasesDisponiblesCamion(Model model) {
		TipoVehiculo tipo = (TipoVehiculo.camión);
		double precioNuevo = clase.cambiarPrecioClases();
		model.addAttribute("precioNuevo", precioNuevo);

		List<Clase> clasesCamionDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
		model.addAttribute("clasesDisponibles", clasesCamionDisponibles);
		return "user/PlantillaClasesVehiculo";

	}

	/*@GetMapping("/reservarClase/{id}")
	public String hacerReservaClase(@AuthenticationPrincipal Usuario user, @PathVariable("id") Long id,
			Model model) {

		
		
		if (clase.anhadirClaseUsuario(user, id)) {

			model.addAttribute("atributo", true);
			model.addAttribute("profesor",profesor.findAll());
			model.addAttribute("vehiculo",vehiculo.findAll());
			model.addAttribute("usuario",usuario.findAll());
			
			return "user/reservaClase";
		} else {
			return "error";
		}
	}*/

	@PostMapping("/reservarClase/submit")
	public String reserva(@ModelAttribute("reservarClase") Clase claseReservada,
			@AuthenticationPrincipal Usuario user) {
		Optional<Usuario> optionalUsuario = usuario.findById(user.getId());

		if (!claseReservada.isEstaOcupada() && user.isTieneCarnetAutoescuela()) {

			double precioNuevo = clase.cambiarPrecioClases();
			claseReservada.setPrecio(precioNuevo);
			clase.save(claseReservada);
			clase.anhadirClaseUsuario(optionalUsuario.get(), claseReservada.getId());

			return "redirect:/PlantillaClasesVehiculo";
		} else {
			return "error";
		}
	}

}