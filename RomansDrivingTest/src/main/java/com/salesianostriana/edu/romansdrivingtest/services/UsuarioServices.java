package com.salesianostriana.edu.romansdrivingtest.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdrivingtest.model.Usuario;

@Service
public class UsuarioServices {

	public List<Usuario> mostrarListaUsuarios(){
		
		return Arrays.asList(new Usuario(1,"Carlos","1","Roman","a","carlosromna","1","1",true,true,LocalDate.now()),
			new Usuario(2,"David","2","rumbao","b","drf","2","2",true,false,LocalDate.now()));
		
				
	}
	
	
	    
}
