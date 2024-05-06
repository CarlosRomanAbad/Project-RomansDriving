package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clase {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Usuario usuario;
    
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
	