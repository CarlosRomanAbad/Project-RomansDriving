package com.salesianostriana.edu.romansdriving.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.Profesor;
import com.salesianostriana.edu.romansdriving.repository.ClaseRepository;
import com.salesianostriana.edu.romansdriving.repository.ProfesorRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class ProfesorService extends BaseServiceImpl<Profesor, Long, ProfesorRepository> {

	private Clase clase;

	@Autowired
	private ProfesorRepository profesorRepo;

//	@Autowired
//	private ClaseRepository claseRepo;
    @Autowired
    private ClaseRepository claseRepository;

	/*
	 * public void borrarProfesor(Long id) { Profesor profesor =
	 * profesorRepo.findById(id) .orElseThrow(() -> new
	 * IllegalArgumentException("Profesor no encontrado")); List<Clase> clases =
	 * claseRepo.findAll();
	 * 
	 * boolean encontrado = false;
	 * 
	 * for (Clase listaClases : clases) {
	 * 
	 * if(listaClases.getProfesor() == null){ continue; }
	 * 
	 * if(listaClases.getProfesor().getId() == profesor.getId()){ encontrado = true;
	 * } } if(encontrado){ clase.removeFromClaseProfe(profesor); }
	 * 
	 * profesorRepo.deleteById(id); }
	 */

	public Profesor profesorConMasClases() {
		return profesorRepo.findProfesorWithMostClasses();
	}

	public boolean comprobarProfeConClase(Long id) {

		Optional<Profesor> profesorBuscado = profesorRepo.findById(id);
		Profesor profesor = profesorBuscado.get();

		if (profesor.getClases() != null && !profesor.getClases().isEmpty()) {

			return true;

		} else {
			return false;
		}
	}

	public void eliminarProfesor(Long id){
		Optional<Profesor> profesorBuscado = profesorRepo.findById(id);

		if(profesorBuscado.isPresent()){
			profesorBuscado.get().setFechaBaja(LocalDate.now());
			profesorRepo.save(profesorBuscado.get());
		}
	}

	public List<Profesor> profesoresInactivos(){

		List<Profesor> profesores = profesorRepo.findAll();

		return profesores.stream()
		.filter(profesor -> profesor.getFechaBaja() != null)
		.collect(Collectors.toList());
	}

}

	

