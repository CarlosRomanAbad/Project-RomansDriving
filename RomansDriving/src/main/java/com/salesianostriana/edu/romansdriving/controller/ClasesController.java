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


        List<Clase> clasesDisponibles = clase.obtenerClasesMasRecientesNoOcupadas();

        double precioNuevo = clase.cambiarPrecioClases();

        model.addAttribute("clasesDisponibles", clasesDisponibles);
        model.addAttribute("precioNuevo",precioNuevo);
        return "user/PlantillaClasesVehiculo";
    }

    @GetMapping("/PlantillaClasesCoche")
    public String mostrarClasesDisponiblesCoche(Model model) {
        TipoVehiculo tipo = (TipoVehiculo.coche);
        double precioNuevo = clase.cambiarPrecioClases();

        List<Clase> clasesCocheDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
        model.addAttribute("clasesDisponibles", clasesCocheDisponibles);
        model.addAttribute("precioNuevo",precioNuevo);
        return "user/PlantillaClasesVehiculo";

    }

    @GetMapping("/PlantillaClasesMoto")
    public String mostrarClasesDisponiblesMoto(Model model) {
        TipoVehiculo tipo = (TipoVehiculo.moto);
        double precioNuevo = clase.cambiarPrecioClases();

        List<Clase> clasesMotoDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
        model.addAttribute("clasesDisponibles", clasesMotoDisponibles);
        model.addAttribute("precioNuevo",precioNuevo);
        return "user/PlantillaClasesVehiculo";

    }

    @GetMapping("/PlantillaClasesCamion")
    public String mostrarClasesDisponiblesCamion(Model model) {
        TipoVehiculo tipo = (TipoVehiculo.camión);
        double precioNuevo = clase.cambiarPrecioClases();
        model.addAttribute("precioNuevo",precioNuevo);

        List<Clase> clasesCamionDisponibles = clase.obtenerClasesCocheDisponibles(tipo);
        model.addAttribute("clasesDisponibles", clasesCamionDisponibles);
        return "user/PlantillaClasesVehiculo";

    }




    @GetMapping("/reservarClase/{id}")
    public String hacerReservaClase(@AuthenticationPrincipal Usuario usuario, @PathVariable("id") Long id, Model model) {

        //si se cumple la condicion de la consulta
        if (clase.anhadirClaseUsuario(usuario, id)) {

            //que se haga el metodo del servicio donde se setea el usuario que esta en la pagina, y la clase pasa a estar ocupada
            model.addAttribute("atributo", true); // Si quieres pasar el atributo "true" para indicar éxito
            return "user/reservaClase";
        } else {
            return "error";
        }
    }

    @PostMapping("/reservarClase/submit")
    public String reserva(@ModelAttribute("reservarClase") Clase claseReservada, @AuthenticationPrincipal Usuario user) {
        Optional<Usuario> optionalUsuario = usuario.findById(user.getId());

        if (optionalUsuario.isPresent() && !claseReservada.isEstaOcupada()) {
            // Obtener el precio actualizado
            double precioNuevo = clase.cambiarPrecioClases();
            // Establecer el precio actualizado en la clase reservada
            claseReservada.setPrecio(precioNuevo);

            // Guardar la clase reservada en la base de datos
            clase.save(claseReservada);

            // Añadir el usuario a la clase reservada
            clase.anhadirClaseUsuario(optionalUsuario.get(), claseReservada.getId());

            return "redirect:/PlantillaClasesVehiculo";
        } else {
            return "error";
        }
    }





}