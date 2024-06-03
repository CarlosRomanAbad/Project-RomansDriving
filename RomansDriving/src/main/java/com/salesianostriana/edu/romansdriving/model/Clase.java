package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @JoinColumn(name="usuario_id", foreignKey = @ForeignKey(name="fk_clase_usuario"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="profesor_id", foreignKey = @ForeignKey(name="fk_clase_profesor"))
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name="vehiculo_id", foreignKey = @ForeignKey(name="fk_clase_vehiculo"))
    private Vehiculo vehiculo;

    private double precio;

    private boolean estaOcupada;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fechaClase;
    
    
    
    public void addToUsuario(Usuario usuario) {
		this.usuario=usuario;
		usuario.getClases().add(this);
	}

	public void removeFromClase(Usuario usuario) {
		usuario.getClases().remove(this);
		this.usuario=null;
	}
	
	public void addToProfesor(Profesor profesor) {
		this.profesor=profesor;
		profesor.getClases().add(this);
	}

	public void removeFromClaseProfe(Profesor profesor) {
		profesor.getClases().remove(this);
		this.profesor=null;
	}
	
	public void addToVehiculo(Vehiculo vehiculo) {
		this.vehiculo=vehiculo;
		vehiculo.getClases().add(this);
	}

	public void removeFromClaseVehiculo(Vehiculo vehiculo) {
		vehiculo.getClases().remove(this);
		this.vehiculo=null;
	}
}
