package com.salesianostriana.edu.romansdriving.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    private List<Clase> clases = new ArrayList<>();

    private String nombre;
    private String apellidos;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;
}