package com.salesianostriana.edu.romansdriving.exceptions;

public class ExcepcionBorrarVehiculo extends RuntimeException{

    public ExcepcionBorrarVehiculo (){

    }

    public ExcepcionBorrarVehiculo (String msj){
        super("no se puede borrar el vehiculo");
    }
}
