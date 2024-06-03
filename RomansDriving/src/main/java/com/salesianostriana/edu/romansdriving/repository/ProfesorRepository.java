package com.salesianostriana.edu.romansdriving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.edu.romansdriving.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

	@Query("SELECT p FROM Profesor p JOIN p.clases c GROUP BY p ORDER BY COUNT(c) DESC LIMIT 1")
   Profesor findProfesorWithMostClasses();
}
