package com.salesianostriana.edu.romansdriving.exceptions;

public class ExcepcionBorrarProfesor extends RuntimeException {

	  public ExcepcionBorrarProfesor (){

	    }

	    public ExcepcionBorrarProfesor (String msj){
	        super("no se puede borrar el profesor");
	    }
	    
}
