package com.salesianostriana.edu.romansdriving.exceptions;

public class ExcepcionBorrarUsuario extends RuntimeException{

	  public ExcepcionBorrarUsuario (){

	    }

	    public ExcepcionBorrarUsuario (String msj){
	        super("no se puede borrar el usuario");
	    }
}
