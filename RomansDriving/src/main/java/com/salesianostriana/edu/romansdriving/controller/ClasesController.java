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
	public String mostrarReservaSeleccionada(@PathVariable("id") Long id, Model model, Usuario user) {
		Optional<Clase> optionalClase = clase.findById(id);

	
			Clase claseSeleccionada = optionalClase.get();
			model.addAttribute("reserva", claseSeleccionada);
			model.addAttribute("precioNuevo", clase.reservarClaseCambioPrecio(user, id));
			//claseSeleccionada.setPrecio(clase.reservarClaseCambioPrecio(user, id));
			//clase.save(claseSeleccionada);
			return "user/reservaClase";
		
		
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
	public String mostrarClasesDisponibles(Model model, @AuthenticationPrincipal Usuario user, Long id) {
	    clase.actualizarClasesFueraPlazo();
	    
	    
	    List<Clase> clasesDisponibles = clase.obtenerClasesMasRecientesNoOcupadas();

	    	
	      model.addAttribute("clasesDisponibles", clasesDisponibles);
	    return "user/PlantillaClasesVehiculo";
	}

	@GetMapping("/PlantillaClasesCoche")
	public String mostrarClasesDisponiblesCoche(Model model,@AuthenticationPrincipal Usuario user,  Long id) {
		TipoVehiculo tipo = (TipoVehiculo.coche);
		

		List<Clase> clasesCocheDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
		model.addAttribute("clasesDisponibles", clasesCocheDisponibles);
		return "user/PlantillaClasesVehiculo";

	}

	@GetMapping("/PlantillaClasesMoto")
	public String mostrarClasesDisponiblesMoto(Model model,@AuthenticationPrincipal Usuario user,  Long id) {
		TipoVehiculo tipo = (TipoVehiculo.moto);
		
	
		List<Clase> clasesMotoDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
		model.addAttribute("clasesDisponibles", clasesMotoDisponibles);
		return "user/PlantillaClasesVehiculo";

	}

	@GetMapping("/PlantillaClasesCamion")
	public String mostrarClasesDisponiblesCamion(Model model,@AuthenticationPrincipal Usuario user,  Long id) {
		TipoVehiculo tipo = (TipoVehiculo.camión);
		Double precioClase;
		


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
			@AuthenticationPrincipal Usuario user, @PathVariable Long id) {
		Optional<Usuario> optionalUsuario = usuario.findById(user.getId());

		if (!claseReservada.isEstaOcupada() && user.isTieneCarnetAutoescuela()) {


			claseReservada.setPrecio(clase.reservarClaseCambioPrecio(user, null));
			clase.save(claseReservada);
			clase.anhadirClaseUsuario(optionalUsuario.get(), claseReservada.getId());

			return "redirect:/PlantillaClasesVehiculo";
		} else {
			return "error";
		}
	}

	@GetMapping("/mostrarClases")
	public String mostrarMisClases(@AuthenticationPrincipal Usuario usuario , Model model , Long id){
		
		List<Clase> clasesUsuario = usuario.getClases();
		model.addAttribute("misClases", clasesUsuario);
		return "user/misClases";

	}
	@GetMapping("cancelarClase/{id}")
    public String cancelarClase(@PathVariable Long id, Usuario user) {
        clase.cancelarClase(id, user);
        return "redirect:/mostrarClases"; 
    }

	

}