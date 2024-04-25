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
public class Vehiculo {

<<<<<<< HEAD

=======
	
>>>>>>> 93609c624f2acede6968f2a2ee1d220c7fc6fbd8
	private Long id;
	private String marca , matricula;
	private boolean estaOcupado;
	private LocalDate fechaOcupacion;
	
}
