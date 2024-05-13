package com.salesianostriana.edu.romansdriving.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.Profesor;
import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.model.Vehiculo;
import com.salesianostriana.edu.romansdriving.service.ClaseService;
import com.salesianostriana.edu.romansdriving.service.ProfesorService;
import com.salesianostriana.edu.romansdriving.service.UsuarioService;
import com.salesianostriana.edu.romansdriving.service.VehiculoService;



@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsuarioService u;

    @Autowired
    private ClaseService c;

    @Autowired
    private ProfesorService p;

    @Autowired
    private VehiculoService v;
    
    //ADMIN PRINCIPAL
    
    @GetMapping("/")
    public String init(Model model) {
    	model.addAttribute("listaUsuarios", u.findAll());
    	
    	return "admin/gestionUsuarios";
    }

    // MUESTRO FORMULARIOS
    @GetMapping("/gestionUsuarios")
    public String mostrarLista(Model model) {
        model.addAttribute("listaUsuarios", u.findAll());
        return "admin/gestionUsuarios";
    }

    @GetMapping("/gestionClases")
    public String mostrar(Model model) {
        model.addAttribute("listaClases", c.findAll());
        return "admin/gestionClases";
    }

    @GetMapping("/gestionProfesores")
    public String mostrarProfesores(Model model) {
        model.addAttribute("listaProfesores", p.findAll());
        return "admin/gestionProfesores";
    }

    @GetMapping("/gestionVehiculos")
        public String mostrarVehiculos(Model model){
            model.addAttribute("listaVehiculos", v.findAll());
            return "admin/gestionVehiculos";
    }
    

    // FORMULARIO AÑADIR
    @GetMapping("/formularioClases")
    public String mostrarFormularioClases(Model model) {
        model.addAttribute("clase", new Clase());
        return "admin/formularioClases";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "admin/formulario";
    }

    @GetMapping("/formularioProfesores")
    public String mostrarFormularioProfesores(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "admin/formularioProfesores";
    }

    @GetMapping("/formularioVehiculos")
    public String mostrarFormularioVehiculos(Model model) {

        model.addAttribute("vehiculo", new Vehiculo());
        return "admin/formularioVehiculos";
    }
    

    // POST DE GUARDAR
    @PostMapping("/guardarUsuario/submit")
    public String guardarUsuario(@ModelAttribute Usuario usuario, Model model) {
        u.save(usuario);
        return "redirect:/admin/gestionUsuarios";
    }

    @PostMapping("/guardarClase/submit")
    public String guardarClase(@ModelAttribute Clase clase, Model model) {
        c.save(clase);
        return "redirect:/admin/gestionClases";
    }
    
    @PostMapping("/guardarProfesor/submit")
    public String guardarProfesor(@ModelAttribute Profesor profesor, Model model) {
    
    	p.save(profesor);
        return "redirect:/admin/gestionProfesores";
    }

    @PostMapping("/guardarVehiculo/submit")
    public String guardarVehiculo(@ModelAttribute Vehiculo vehiculo, Model model){

        v.save(vehiculo);
        return "redirect:/admin/gestionVehiculos";
    }

    // EDITAR USUARIOS
    @GetMapping("/editUsuario/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
        Optional<Usuario> aEditar = u.findById(id);

        if (aEditar.isPresent()) {
            model.addAttribute("usuario", aEditar.get());
            return "admin/formulario";
        } else {
            return "redirect:/admin/gestionUsuarios";
        }
    }

    @GetMapping("/editClase/{id}")
    public String mostrarFormularioEdicionClase(@PathVariable("id") Long id, Model model) {
        Optional<Clase> aEditar = c.findById(id);

        if (aEditar.isPresent()) {
            model.addAttribute("clase", aEditar.get());
            return "admin/formularioClases";
        } else {
            return "redirect:/admin/gestionClases";
        }
    }
    
    @GetMapping("/editProfesor/{id}")
    public String mostrarFormularioEdicionProfesor(@PathVariable("id") Long id, Model model) {
        Optional<Profesor> aEditar = p.findById(id);

        if (aEditar.isPresent()) {
            model.addAttribute("profesor", aEditar.get());
            return "admin/formularioProfesores";
        } else {
            return "redirect:/admin/gestionProfesores";
        }
    }

    @GetMapping("/editVehiculo/{id}")
    public String mostrarFormularioEdicionVehiculo(@PathVariable("id") Long id, Model model) {
        Optional<Vehiculo> aEditar = v.findById(id);

        if (aEditar.isPresent()) {
            model.addAttribute("vehiculo", aEditar.get());
            return "admin/formularioVehiculos";
        } else {
            return "redirect:/admin/gestionVehiculos";
        }
    }


    // POST DE EDITAR
    @PostMapping("/editUsuario/submit")
    public String editarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        u.save(usuario);
        return "redirect:/admin/gestionProfesores";
    }

    @PostMapping("/editClase/submit")
    public String editarClase(@ModelAttribute("clase") Clase clase) {
        c.save(clase);
        return "redirect:/admin/gestionClases";
    }
    
    @PostMapping("/editProfesor/submit")
    public String editarProfesor(@ModelAttribute("profesor") Profesor profesor) {
        p.save(profesor);
        return "redirect:/admin/gestionProfesores";
    }

    @PostMapping("/editVehiculo/submit")
    public String editarVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo) {
        v.save(vehiculo);
        return "redirect:/admin/gestionVehiculos";
    }

    // BORRAR
    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable("id") long id) {
        u.deleteById(id);
        return "redirect:/admin/gestionUsuarios";
    }

    @GetMapping("/borrarClase/{id}")
    public String borrarClase(@PathVariable("id") long id) {
        c.deleteById(id);
        return "redirect:/admin/gestionClases";
    }
    
    @GetMapping("/borrarProfesor/{id}")
    public String borrarProfesor(@PathVariable("id") long id) {
        p.deleteById(id);
        return "redirect:/admin/gestionProfesores";
    }

    @GetMapping("/borrarVehiculo/{id}")
    public String borrarVehiculo(@PathVariable("id")Long id){
        v.deleteById(id);
        return "redirect:/admin/gestionVehiculos";
    }
}
