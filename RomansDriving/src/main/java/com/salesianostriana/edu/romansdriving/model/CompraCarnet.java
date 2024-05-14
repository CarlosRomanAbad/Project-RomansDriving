package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CompraCarnet {

	@EmbeddedId
	private FechasPK fechasPK = new FechasPK();
	
	
	
	@ManyToOne
	@MapsId("usuario")
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@MapsId("carnet")
	@JoinColumn(name = "carnet_id")
	private Carnet carnet;

	public CompraCarnet(Usuario usuario, Carnet carnet) {
		super();
		this.usuario = usuario;
		this.carnet = carnet;
	}
	
	private LocalDate fechaInicio , fechaFin;
	
	
	public void addToUsuario(Usuario a) {
		a.getCarnet().add(this);
		this.usuario = a;
	}

	public void removeFromusuario(Usuario a) {
		a.getCarnet().remove(this);
		this.usuario = null;
	}

	
}
