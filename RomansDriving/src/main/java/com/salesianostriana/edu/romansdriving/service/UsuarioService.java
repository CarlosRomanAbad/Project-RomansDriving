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
                1L, // ID del usuario
                "Carlos", // Nombre
                "12345678A", // DNI
                "García Pérez", // Apellidos
                "carlosg", // Nombre de usuario
                "carlos@example.com", // Correo electrónico
                "contraseña123", // Contraseña
                "123456789", // Teléfono
                true, // Tiene carné de autoescuela
                true, // Es administrador
                LocalDate.now() // Fecha de nacimiento
            )
        );
}
}
