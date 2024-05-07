package com.salesianostriana.edu.romansdriving.model;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario {	
    
	@Id
	@GeneratedValue
    private Long id;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Clase> clase = new ArrayList<>();
	
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "compra_carnet",
            joinColumns = @JoinColumn(name = "usuario_id"), 
            inverseJoinColumns = @JoinColumn(name = "carnet_id") 
    )
	private List<Carnet>carnet = new ArrayList<>();
	
    private String nombre, dni, apellidos, nombreUsuario, email, contrasenha, telefono;
    private boolean tieneCarnetAutoescuela , isAdmin;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
	
    public Usuario(Long id, String nombre, String dni, String apellidos, String nombreUsuario, String email,
			String contrasenha, String telefono, boolean tieneCarnetAutoescuela) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasenha = contrasenha;
		this.telefono = telefono;
		this.tieneCarnetAutoescuela = tieneCarnetAutoescuela;
	}

	public Usuario(Long id, String nombre, String dni, String apellidos, String nombreUsuario, String email,
			String contrasenha, String telefono) {
		this.nombre = nombre;
		this.dni = dni;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasenha = contrasenha;
		this.telefono = telefono;
	}
    
    
    
    
	
    
    
    
    
}
