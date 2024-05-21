package com.salesianostriana.edu.romansdriving.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.Usuario;

public interface UsuarioRepository 
	extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findFirstByUsername(String username);
	
	 @Query("SELECT u FROM Usuario u WHERE u.tieneCarnetAutoescuela = true")
	    List<Usuario> findAllByTieneCarnetAutoescuela(); 


	 
	 //@Query("SELECT u FROM Usuario u WHERE u.id = :id AND u.fechaNacimiento > CURRENT_DATE() ")
	 //boolean fechaNacimientoIncorrecta(@Param("id") Long id);
}
/* */