package com.salesianostriana.edu.romansdriving.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.TipoVehiculo;
import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.repository.ClaseRepository;
import com.salesianostriana.edu.romansdriving.repository.UsuarioRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

import jakarta.transaction.Transactional;

@Service
public class ClaseService extends BaseServiceImpl<Clase, Long, ClaseRepository> {

	@Autowired
	private ClaseRepository claseRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	public List<Clase> obtenerClasesNoOcupadas() {
		return claseRepository.findClasesNoOcupadas();
	}

	public List<Clase> obtenerClasesMasRecientesNoOcupadas() {
		return claseRepository.findAllClasesNoOcupadasOrderByFechaClase();
	}

	public List<Clase> obtenerClasesCocheDisponibles(TipoVehiculo tipo) {
		return claseRepository.findAllClasesCocheDesOcupadas(tipo);
	}

	public List<Clase> obtenerClasesMotoDisponibles(TipoVehiculo tipo) {

		return claseRepository.findAllClasesMotoDesOcupadas(tipo);
	}

	public List<Clase> obtenerClasesCamionDisponibles(TipoVehiculo tipo) {
		return claseRepository.findAllClasesCamionDesOcupadas(tipo);
	}

	public List<Clase> obtenerClasesDeAlumnoConCarnet() {
		return claseRepository.findClasesConUsuarioConCarnetAutoescuela();
	}

	public List<Clase> actualizarClasesFueraPlazo() {

		LocalDate fechaActual = LocalDate.now();
		List<Clase> clasesFueraPlazo = claseRepository.findClasesFueraPlazo();

		clasesFueraPlazo.forEach(c -> c.setEstaOcupada(true));

		return claseRepository.saveAll(clasesFueraPlazo);
	}

	@Transactional
	public boolean anhadirClaseUsuario(Usuario user, Long id) {
		Optional<Clase> claseConUsuario = claseRepository.findClaseByIdAndNoOcupada(id);

		if (claseConUsuario.isPresent ()) {
			Clase clase = claseConUsuario.get();
			clase.addToUsuario(user);
			clase.setEstaOcupada(true);
			this.save(clase);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
    public void cancelarClase(Long claseId, Usuario usuario) {
        claseRepository.cancelarClase(claseId);
        
    }
	


	  public double reservarClaseCambioPrecio(Usuario user, Long claseid) {
		  
		  if(claseRepository.clasesConUsuariosAsociados(user.getId())>0) {
			  return claseRepository.findById(claseid).get().getPrecio()/2;
		  }
		  else {
			  return claseRepository.findById(claseid).get().getPrecio();
		  }
		  
	  }

	  
	

}
