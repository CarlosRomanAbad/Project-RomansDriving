package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Vehiculo {

	
	private Long id;
	private String marca , matricula;
	private boolean estaOcupado;
	private LocalDate fechaOcupacion;
	
}
