package com.salesianostriana.edu.romansdriving.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	private PasswordEncoder passwordEncoder;
	
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

    LocalDateTime now = LocalDateTime.now();
    String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
    model.addAttribute("fechaMinima", formattedDateTime);

    model.addAttribute("profesores", p.findAll());
    model.addAttribute("usuarios", u.findAll());

    return "admin/formularioClases";
}

    @GetMapping("/formulario/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "admin/formulario";
    }

    @GetMapping("/formularioProfesores")
    public String mostrarFormularioProfesores(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "admin/formularioProfesores";
    }

    @GetMapping("/formularioVehiculos/")
    public String mostrarFormularioVehiculos(Model model) {

        model.addAttribute("vehiculo", new Vehiculo());
        return "admin/formularioVehiculos";
    }
    

    // POST DE GUARDAR
    @PostMapping("/guardarUsuario/submit")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
    	if (u.usuarioExistente(usuario.getUsername())) {
    	    return "redirect:/admin/formulario/?error=usuarioExistente"; 
    	}
 
        String encodedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encodedPassword);
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

    @PostMapping("/guardarVehiculo/submit/")
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
            model.addAttribute("profesores", p.findAll());
            model.addAttribute("usuarios", u.findAll());
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

    @GetMapping("/editVehiculo/{id}/")
    public String mostrarFormularioEdicionVehiculo(@PathVariable("id") Long id, Model model) {
        Optional<Vehiculo> aEditar = v.findById(id);

        if (aEditar.isPresent()) {
            model.addAttribute("vehiculo", aEditar.get());
            return "admin/formularioVehiculos";
        } else {
            return "redirect:/admin/gestionVehiculos/";
        }
    }


    @PostMapping("/editUsuario/submit")
    public String editarUsuario(@ModelAttribute("usuario") Usuario usuario, @RequestParam(value = "nuevaPassword", required = false) String nuevaPassword, Long id) {
    
        if (nuevaPassword != null && !nuevaPassword.isEmpty()) {
            String encodedPassword = passwordEncoder.encode(nuevaPassword);
            usuario.setPassword(encodedPassword);
        } else {       
            usuario.setPassword(u.findById(id).get().getPassword());
            usuario.setDni(u.findById(id).get().getDni());
        }
	        u.save(usuario);
	        return "redirect:/admin/gestionUsuarios";
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

        @PostMapping("/editVehiculo/submit/")
        public String editarVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo) {

            if(v.comprobarAntiguedadVehiculo(vehiculo)){
                v.save(vehiculo);
                return "redirect:/admin/gestionVehiculos/";
            }
            else{
                return "redirect:/admin/editVehiculo/"+vehiculo.getNumBastidor()+"/?errorDos=true";
            }
        }

    // BORRAR
    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable("id") long id) {
    	if(u.findById(id).get().isAdmin()) {
    		return "errorBorrarAdmin";
    	}
    	else {
    		 u.deleteById(id); 
    	        return "redirect:/admin/gestionUsuarios";
    	}
    }

    @GetMapping("/borrarClase/{id}")
    public String borrarClase(@PathVariable("id") long id, Usuario usuario) {
    	
    	
    	if(c.findById(id).get().getUsuario()!=null) {
    		c.findById(id).get().removeFromClase(c.findById(id).get().getUsuario());
        	c.findById(id).get().removeFromClaseProfe(c.findById(id).get().getProfesor());
        	c.findById(id).get().removeFromClaseVehiculo(c.findById(id).get().getVehiculo());
            c.deleteById(id);
            return "redirect:/admin/gestionClases";
    	}
    	else {
    		c.findById(id).get().removeFromClaseProfe(c.findById(id).get().getProfesor());
        	c.findById(id).get().removeFromClaseVehiculo(c.findById(id).get().getVehiculo());
    		c.deleteById(id);
    		
    		 return "redirect:/admin/gestionClases";
    	}
    	
    }
    
    @GetMapping("/borrarProfesor/{id}")
    public String borrarProfesor(@PathVariable("id") long id) {
        
    	Profesor profesor = p.findById(id).get();
    	
    	if(profesor !=null) {
    		profesor.setFechaBaja(LocalDate.now());
    		p.save(profesor);
    	}
    	
        return "redirect:/admin/gestionProfesores";
    }

    @GetMapping("/borrarVehiculo/{id}")
    public String borrarVehiculo(@PathVariable("id")Long id){
        v.deleteById(id);
        return "redirect:/admin/gestionVehiculos";
    }


    @GetMapping("/gestionGanancias")

    public String mostrarGanancias(Model model){

        model.addAttribute("gananciasClasesAsignadas",c.gananciasClasesAsignadas());
        model.addAttribute("profeMasClases",p.profesorConMasClases());
        return "admin/gestionGanancias";
    }
}
