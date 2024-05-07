package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clase {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_clase_usuario"))  
    private Usuario usuario;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaClase;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_clase_profesor"))  
    private Profesor profesor;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_clase_vehiculo"))  
    private Vehiculo vehiculo;
    
    private double precio;
    
    private boolean estaOcupada;

    
    

	
    
    
    
}
	