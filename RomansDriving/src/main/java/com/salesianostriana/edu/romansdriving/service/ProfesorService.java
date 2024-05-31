package com.salesianostriana.edu.romansdriving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.Profesor;
import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.repository.ClaseRepository;
import com.salesianostriana.edu.romansdriving.repository.ProfesorRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class ProfesorService extends BaseServiceImpl<Profesor,Long,ProfesorRepository> {

	
	private Clase clase;
	
	@Autowired
	private ProfesorRepository profesorRepo;
	
	@Autowired
	private ClaseRepository claseRepo;
	
	public void borrarProfesor(Long id) {
        Profesor profesor = profesorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Profesor no encontrado"));
        List<Clase> clases = claseRepo.findAll();

        if (clases.contains(profesor)) {
           clase.removeFromClaseProfe(profesor);
           profesorRepo.deleteById(id);
        }
	}
	
	public Profesor profesorConMasClases() {
		return profesorRepo.findProfesorWithMostClasses();
	}
}
