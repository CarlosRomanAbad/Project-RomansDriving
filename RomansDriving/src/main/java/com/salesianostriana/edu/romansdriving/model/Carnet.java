package com.salesianostriana.edu.romansdriving.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.StreamReadConstraints.Builder;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
public class Carnet {

	@Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "carnet", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Usuario> usuarios = new ArrayList<>();
	
}
