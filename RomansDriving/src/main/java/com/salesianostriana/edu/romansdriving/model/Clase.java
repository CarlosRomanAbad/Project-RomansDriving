package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clase {

<<<<<<< HEAD

=======
	
>>>>>>> 93609c624f2acede6968f2a2ee1d220c7fc6fbd8
	private LocalDate fechaClase;
	private Usuario usuario;
	private Vehiculo vehiculoAsignado;
	private double precioClase;
	
}
