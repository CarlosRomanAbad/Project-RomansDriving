package com.salesianostriana.edu.romansdriving.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;



@Entity
@DiscriminatorValue("A")
public class Admin extends Usuario{

	
	
}
