package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
	
    @Id
    @GeneratedValue
    private Long id;

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Clase> clases = new ArrayList<>();

    private String nombre;
    private String apellidos;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaBaja;
    
    
}