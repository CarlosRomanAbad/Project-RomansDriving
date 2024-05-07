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
import com.salesianostriana.edu.romansdriving.repository.ClaseRepository;
import com.salesianostriana.edu.romansdriving.repository.ProfesorRepository;
import com.salesianostriana.edu.romansdriving.service.UsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsuarioService u;

    @Autowired
    private ClaseRepository c;

    @Autowired
    private ProfesorRepository p;

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

    // POST DE GUARDAR
    @PostMapping("/guardarUsuario/submit")
    public String guardarUsuario(@ModelAttribute Usuario usuario, Model model) {
        u.save(usuario);
        return "redirect:/gestionUsuarios";
    }

    @PostMapping("/guardarClase/submit")
    public String guardarClase(@ModelAttribute Clase clase, Model model) {
        c.save(clase);
        return "redirect:/admin/gestionClases";
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

    // POST DE EDITAR
    @PostMapping("/editUsuario/submit")
    public String editarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        u.save(usuario);
        return "redirect:/admin/gestionUsuarios";
    }

    @PostMapping("/editClase/submit")
    public String editarClase(@ModelAttribute("clase") Clase clase) {
        c.save(clase);
        return "redirect:/admin/gestionClases";
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
}
