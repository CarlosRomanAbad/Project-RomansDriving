package com.salesianostriana.edu.romansdrivingtest.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private int id;
    private String nombre , dni , apellidos , usuario , email , contrasenha , telefono;
    private boolean tieneCarnetAutoescuela ,isAdmin;;
    private LocalDate fechaNacimiento;
    
}
