package com.salesianostriana.edu.romansdriving.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;



@Entity
@DiscriminatorValue("C")
public class Cliente extends Usuario {

	

	
}
