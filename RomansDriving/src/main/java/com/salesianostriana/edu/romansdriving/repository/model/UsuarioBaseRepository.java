package com.salesianostriana.edu.romansdriving.repository.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.salesianostriana.edu.romansdriving.model.Usuario;

@NoRepositoryBean
public interface UsuarioBaseRepository<T  extends Usuario> extends JpaRepository<T , Long> {

}
