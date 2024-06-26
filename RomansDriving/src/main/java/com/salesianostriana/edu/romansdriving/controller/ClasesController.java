package com.salesianostriana.edu.romansdriving.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	public String mostrarReservaSeleccionada(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal Usuario user) {
	    Optional<Clase> optionalClase = clase.findById(id);
	    clase.comprobarFechaMasDeSieteDias(id);
		//usuario.comprobarGastosUsuarios(id);
	    if (optionalClase.isPresent()) {
	        Clase claseSeleccionada = optionalClase.get();

	  
	        if (clase.comprobarTieneCarnet(user.getId())) {
	            //double precioNuevo = clase.aplicarDescuentoClase(id);
	            claseSeleccionada.setPrecio(optionalClase.get().getPrecio()/2);
	            //clase.save(claseSeleccionada);
	        }

			
	        model.addAttribute("reserva", claseSeleccionada);
	        model.addAttribute("precioClase", claseSeleccionada.getPrecio());

	        return "user/reservaClase";
	    } else {
	       
	        return "error";
	    }
	}
	
	@GetMapping("/reserva/{id}/confirmar")
	public String confirmarReserva(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal  Usuario usuario) {
		clase.comprobarFechaMasDeSieteDias(id);
		
		if (clase.anhadirClaseUsuario(usuario, id)) {
			return "redirect:/mostrarClases";
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
    model.addAttribute("currentPage", "vehiculo");
    return "user/PlantillaClasesVehiculo";
}

@GetMapping("/PlantillaClasesCoche")
public String mostrarClasesDisponiblesCoche(Model model, @AuthenticationPrincipal Usuario user, Long id) {
    TipoVehiculo tipo = TipoVehiculo.COCHE;
    List<Clase> clasesCocheDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
    model.addAttribute("clasesDisponibles", clasesCocheDisponibles);
    model.addAttribute("currentPage", "coche");
    return "user/PlantillaClasesVehiculo";
}

@GetMapping("/PlantillaClasesMoto")
public String mostrarClasesDisponiblesMoto(Model model, @AuthenticationPrincipal Usuario user, Long id) {
    TipoVehiculo tipo = TipoVehiculo.MOTO;
    List<Clase> clasesMotoDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
    model.addAttribute("clasesDisponibles", clasesMotoDisponibles);
    model.addAttribute("currentPage", "moto");
    return "user/PlantillaClasesVehiculo";
}

@GetMapping("/PlantillaClasesCamion")
public String mostrarClasesDisponiblesCamion(Model model, @AuthenticationPrincipal Usuario user, Long id) {
    TipoVehiculo tipo = TipoVehiculo.CAMION;
    List<Clase> clasesCamionDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
    model.addAttribute("clasesDisponibles", clasesCamionDisponibles);
    model.addAttribute("currentPage", "camion");
    return "user/PlantillaClasesVehiculo";
}




@GetMapping("/mostrarClases")
public String mostrarMisClases(@AuthenticationPrincipal Usuario usuario , Model model){
    List<Clase> clasesUsuario = usuario.getClases();
    model.addAttribute("misClases", clasesUsuario);
    model.addAttribute("precioTotal", clase.obtenerDineroTotalClasesUsuario(usuario.getId()));
    return "user/misClases";
}
	@GetMapping("cancelarClase/{id}")
    public String cancelarClase(@PathVariable Long id, @AuthenticationPrincipal Usuario user) {
        clase.cancelarClase(id, user);
       
        return "redirect:/mostrarClases"; 
    }

	

}