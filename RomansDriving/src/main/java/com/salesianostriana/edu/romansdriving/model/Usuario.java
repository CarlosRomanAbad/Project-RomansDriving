package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Usuario {	
    
    private Long id;
    private String nombre, dni, apellidos, usuario, email, contrasenha, telefono;
    private boolean tieneCarnetAutoescuela, isAdmin;
    private LocalDate fechaNacimiento;
	
    public Usuario(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}
    
    
    
}
