package com.salesianostriana.edu.romansdriving.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.TipoVehiculo;
import com.salesianostriana.edu.romansdriving.repository.ClaseRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class ClaseService extends BaseServiceImpl<Clase, Long, ClaseRepository> {

	@Autowired
	private ClaseRepository claseRepository;

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

	public List<Clase> obtenerClasesCamionDisponibles(TipoVehiculo tipo){
		return claseRepository.findAllClasesCamionDesOcupadas(tipo);
	}

	public List<Clase> actualizarClasesFueraPlazo() {

		LocalDate fechaActual = LocalDate.now();
		List<Clase> clasesFueraPlazo = claseRepository.findClasesFueraPlazo();


		LocalDate fechaFutura = fechaActual.plusDays(20);
		clasesFueraPlazo.forEach(c -> c.setFechaClase(fechaFutura));


		return claseRepository.saveAll(clasesFueraPlazo);
	}

}
