package com.salesianostriana.edu.romansdriving.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Usuario;

@Service
public class UsuarioService {

    public List<Usuario> getUsuarios() {
        return Arrays.asList(
                new Usuario(
                        1L, 
                        "Carlos", 
                        "12345678A", 
                        "García Pérez", 
                        "carlosg", 
                        "carlos@example.com", 
                        "contraseña123", 
                        "123456789", 
                        true, 
                        true,
                        LocalDate.now()),new Usuario(
                            1L, 
                            "Carlos", 
                            "12345678A", 
                            "García Pérez", 
                            "carlosg", 
                            "carlos@example.com", 
                            "contraseña123", 
                            "123456789", 
                            true, 
                            true,
                            LocalDate.now()));
    }
}
