package com.salesianostriana.edu.romansdriving.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

		@Query("SELECT c FROM Clase c JOIN c.usuario u WHERE u.id = :userId")
    	List<Clase> findClasesDeUnUsuario(@Param("userId") Long userId);
    

		@Modifying
		@Query("UPDATE Clase c SET c.estaOcupada = false, c.usuario = null WHERE c.id = :claseId")
		void cancelarClase(@Param("claseId") Long claseId);
		
		
		@Query("SELECT Count (c) FROM Clase c WHERE c.usuario.id = ?1")
		Long clasesConUsuariosAsociados(Long id);

		
}

