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
import com.salesianostriana.edu.romansdriving.model.Vehiculo;
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
	
	/*public void actualizarSecurityContext(Usuario user) {
		  Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		  
		  SecurityContextHolder.getContext().setAuthentication(auth);
	  }*/
	
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
	
	public void borrarUsuario(Long id) {
        Usuario user = usuario.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        List<Clase> clases = claseRepository.findAll();

        if (clases.contains(user)) {
           clase.removeFromClase(user);
           usuario.deleteById(id);
        }
       
        

    }
}
