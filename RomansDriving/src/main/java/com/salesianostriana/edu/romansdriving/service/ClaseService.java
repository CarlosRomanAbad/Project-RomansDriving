package com.salesianostriana.edu.romansdriving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.repository.ClaseRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class ClaseService extends BaseServiceImpl<Clase,Long,ClaseRepository>{

	   @Autowired
	    private ClaseRepository claseRepository;

	    public List<Clase> obtenerClasesNoOcupadas() {
	        return claseRepository.findClasesNoOcupadas();
	    }

		public List<Clase>obtenerClasesMasRecientesNoOcupadas(){
			return claseRepository.findAllClasesNoOcupadasOrderByFechaClase();
		}
}
