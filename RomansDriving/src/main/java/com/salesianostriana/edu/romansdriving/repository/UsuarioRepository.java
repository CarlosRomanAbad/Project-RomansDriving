package com.salesianostriana.edu.romansdriving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.edu.romansdriving.model.Usuario;

public interface UsuarioRepository 
	extends JpaRepository<Usuario, Long> {

}