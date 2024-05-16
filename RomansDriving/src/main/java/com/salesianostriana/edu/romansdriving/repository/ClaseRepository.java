package com.salesianostriana.edu.romansdriving.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.TipoVehiculo;

@Repository
public interface ClaseRepository extends JpaRepository<Clase , Long> {

	  @Query(value = "SELECT * FROM clase WHERE esta_ocupada = false", nativeQuery = true)
	    List<Clase> findClasesNoOcupadas();


		@Query("SELECT c FROM Clase c WHERE c.estaOcupada = false ORDER BY c.fechaClase ASC")
		List<Clase> findAllClasesNoOcupadasOrderByFechaClase();
		
		
		@Query("SELECT c FROM Clase c WHERE c.vehiculo.tipo = :tipo AND c.estaOcupada = false")
		List<Clase> findAllClasesCocheDesOcupadas(@Param("tipo") TipoVehiculo tipo);
		
		@Query("SELECT c FROM Clase c WHERE c.vehiculo.tipo = :tipo AND c.estaOcupada = false")
		List<Clase> findAllClasesMotoDesOcupadas(@Param("tipo") TipoVehiculo tipo);


		@Query("SELECT c FROM Clase c WHERE c.vehiculo.tipo = :tipo AND c.estaOcupada = false")
		List<Clase> findAllClasesCamionDesOcupadas(@Param("tipo") TipoVehiculo tipo);

		@Query("SELECT c FROM Clase c WHERE c.estaOcupada = false AND c.fechaClase < CURRENT_DATE()")
		List<Clase> findClasesFueraPlazo();

		@Query("SELECT c FROM Clase c WHERE c.id = :id AND c.estaOcupada = false")
		Optional<Clase> findClaseByIdAndNoOcupada(@Param("id") Long id);

		
		@Query("SELECT c FROM Clase c WHERE c.usuario.tieneCarnetAutoescuela = true")
		List<Clase> findClasesConUsuarioConCarnetAutoescuela();
}

