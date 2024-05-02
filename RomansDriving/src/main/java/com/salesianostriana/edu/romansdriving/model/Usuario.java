package com.salesianostriana.edu.romansdriving.model;



import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario {	
    
	@Id
	@GeneratedValue
    private Long id;
	
    private String nombre, dni, apellidos, usuario, email, contrasenha, telefono;
    private boolean tieneCarnetAutoescuela;
    private Date fechaRegistro;
	
    public Usuario(Long id, String nombre, String dni, String apellidos, String usuario, String email,
			String contrasenha, String telefono, boolean tieneCarnetAutoescuela) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.email = email;
		this.contrasenha = contrasenha;
		this.telefono = telefono;
		this.tieneCarnetAutoescuela = tieneCarnetAutoescuela;
	}

	public Usuario(Long id, String nombre, String dni, String apellidos, String usuario, String email,
			String contrasenha, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.email = email;
		this.contrasenha = contrasenha;
		this.telefono = telefono;
	}
    
    
    
    
	
    
    
    
    
}
