package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clase {

	
	private LocalDate fechaClase;
	private Usuario usuario;
	private Vehiculo vehiculoAsignado;
	private double precioClase;
	
}
