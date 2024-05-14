package com.salesianostriana.edu.romansdriving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.edu.romansdriving.model.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase , Long> {

	  @Query(value = "SELECT * FROM clase WHERE esta_ocupada = false", nativeQuery = true)
	    List<Clase> findClasesNoOcupadas();


		@Query("SELECT c FROM Clase c WHERE c.estaOcupada = false ORDER BY c.fechaClase ASC")
		List<Clase> findAllClasesNoOcupadasOrderByFechaClase();
}
