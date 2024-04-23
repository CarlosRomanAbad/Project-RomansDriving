package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue
    private Long id;
    private String nombre , dni , apellidos , usuario , email , contrasenha , telefono;
    private boolean tieneCarnetAutoescuela ,isAdmin;;
    private LocalDate fechaNacimiento;
    
    public Usuario(String dni, String usuario) {
        this.dni = dni;
        this.usuario = usuario;
    }

    
  
}
