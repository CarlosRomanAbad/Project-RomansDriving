package com.salesianostriana.edu.romansdriving.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.repository.ClaseRepository;
import com.salesianostriana.edu.romansdriving.repository.UsuarioRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

	@Autowired
	private UsuarioRepository usuario;
	
	@Autowired ClaseRepository claseRepository;
	
	private Clase clase;
	
	public List<Usuario>mostrarUsuariosConCarnet(){
		
		return usuario.findAllByTieneCarnetAutoescuela();
	}
	
	public void actualizarSecurityContext(Usuario user) {
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		 
		SecurityContextHolder.getContext().setAuthentication(auth);
	  }
	
	public boolean usuarioConFechaIncorrecta(Usuario user) {
		
		if(user.getFechaNacimiento().isAfter(LocalDate.now().minusYears(16))) {
			return false;
		}
		
		else {
			return true;
		}
	}

	public boolean usuarioExistente(String username) {
		return this.repository.existsByUsername(username);
	}
	
	public boolean comprobarUsuarioTieneClase(Long id){
		
		Optional<Usuario>usuarioBuscado = usuario.findById(id);
		Usuario user = usuarioBuscado.get();
		
		if(user.getClases() != null && !user.getClases().isEmpty()) {
			return true;
		}
		
		else {
			return false;
		}
		
		
	}
	

	public double obtenerPrecioClaseConDescuento(Long claseId, Long usuarioId) {
        Optional<Clase> claseOptional = claseRepository.findById(claseId);
        Optional<Usuario> usuarioOptional = usuario.findById(usuarioId);

        if (claseOptional.isPresent() && usuarioOptional.isPresent()) {
            Clase clase = claseOptional.get();
            Usuario user = usuarioOptional.get();

            if (user.isTieneCarnetAutoescuela()) {
                return clase.getPrecio() * 0.5; // Aplicar descuento del 50%
            } else {
                return clase.getPrecio(); // Precio sin descuento
            }
        } else {
            throw new IllegalArgumentException("Clase o Usuario no encontrado");
        }
    }
	
	
}
