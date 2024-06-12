package com.salesianostriana.edu.romansdriving.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	public double gananciasClasesAsignadas() {
		return claseRepository.dineroGeneradoConClasesAsignadas();
	}

	public List<Clase> listaClasesConUsuarios(Long id) {
		return claseRepository.findClasesAndUsuarios(id);
	}

	public List<Clase> actualizarClasesFueraPlazo() {

		//LocalDate fechaActual = LocalDate.now();
		List<Clase> clasesFueraPlazo = claseRepository.findClasesFueraPlazo();

		clasesFueraPlazo.forEach(c -> c.setEstaOcupada(true));

		return claseRepository.saveAll(clasesFueraPlazo);
	}

	@Transactional
	public boolean anhadirClaseUsuario(Usuario user, Long id) {
		Optional<Clase> claseConUsuario = claseRepository.findClaseByIdAndNoOcupada(id);
		Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(user.getId());

		if (claseConUsuario.isPresent() && usuarioEncontrado.isPresent()) {
			Clase clase = claseConUsuario.get();

			if (usuarioEncontrado.get().isTieneCarnetAutoescuela()) {
				clase.setPrecio(clase.getPrecio() / 2);
			}

			clase.addToUsuario(user);
			clase.setEstaOcupada(true);
			claseRepository.save(clase);

			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public void cancelarClase(Long claseId, Usuario usuario) {

		// claseRepository.cancelarClase(claseId);
		Optional<Clase> claseBuscada = claseRepository.findById(claseId);

		if (claseBuscada.isPresent()) {
			Clase clase = claseBuscada.get();

			clase.removeFromClase(usuario);
			clase.setEstaOcupada(false);
			claseRepository.save(clase);
			usuarioService.actualizarSecurityContext(usuario);

		}

	}

	public double reservarClaseCambioPrecio(Usuario user, Long claseid) {

		if (claseRepository.clasesConUsuariosAsociados(user.getId()) > 0) {
			return claseRepository.findById(claseid).get().getPrecio() / 2;
		} else {
			return claseRepository.findById(claseid).get().getPrecio();
		}

	}

	public boolean comprobarPrecioClase(Clase clase) {

		if (clase.getPrecio() >= 0)
			return true;

		else
			return false;

	}

	public boolean comprobarTieneCarnet(Long id ){
		Optional<Usuario>user = usuarioRepository.findById(id);
		boolean tieneCarnet = false;
		if(user.isPresent()){
			if(user.get().isTieneCarnetAutoescuela()){
				tieneCarnet = true;
			}
		}
		return tieneCarnet;

	}
	
	public double aplicarDescuentoClase(Long id) {
		
		Optional <Usuario> user = usuarioRepository.findById(id);
		
		if(user.get().isTieneCarnetAutoescuela()){
			return claseRepository.findById(id).get().getPrecio()/1.4;
		}

		else{
			return claseRepository.findById(id).get().getPrecio();
		}

	}

	public double comprobarFechaMasDeSieteDias(Long id){
		Optional<Clase> claseBuscada = claseRepository.findById(id);



		if (claseBuscada.get().getFechaClase().isAfter(LocalDateTime.now().plusDays(7))) {
			claseBuscada.get().setPrecio(claseRepository.findById(id).get().getPrecio()/1.2);
			return claseBuscada.get().getPrecio();
		}

		else{
			return claseRepository.findById(id).get().getPrecio();
		}

	}
	

}
