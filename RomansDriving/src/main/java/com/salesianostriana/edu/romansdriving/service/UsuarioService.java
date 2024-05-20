package com.salesianostriana.edu.romansdriving.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.repository.UsuarioRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

	@Autowired
	private UsuarioRepository usuario;
	
	public List<Usuario>mostrarUsuariosConCarnet(){
		
		return usuario.findAllByTieneCarnetAutoescuela();
	}
	
	public List<Usuario> calcularPrecioSiTieneCarnet(Long id) {
	    List<Usuario> usuarios = usuario.findAllByTieneCarnetAutoescuela();
	    Clase clase = new Clase();
	    double precioConDescuento = clase.getPrecio() / 2;
	   
	    usuarios.forEach(c -> clase.setPrecio(precioConDescuento));
	    
	    return usuarios;
	}

}
