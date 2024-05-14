package com.salesianostriana.edu.romansdriving.repository;

import org.springframework.stereotype.Repository;

import com.salesianostriana.edu.romansdriving.model.CompraCarnet;
import com.salesianostriana.edu.romansdriving.model.FechasPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraCarnetRepository extends JpaRepository<CompraCarnet, FechasPK>{

}
