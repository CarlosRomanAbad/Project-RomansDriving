package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Vehiculo {

	@Id
	@GeneratedValue
	private Long id;
	private String marca , matricula;
	private boolean estaOcupado;
	private LocalDate fechaOcupacion;
	
}
