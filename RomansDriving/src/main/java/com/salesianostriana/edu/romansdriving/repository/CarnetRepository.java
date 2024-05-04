package com.salesianostriana.edu.romansdriving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.edu.romansdriving.model.Carnet;

public interface CarnetRepository extends JpaRepository<Carnet , Long> {

}
