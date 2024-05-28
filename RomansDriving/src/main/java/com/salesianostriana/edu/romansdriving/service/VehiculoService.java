package com.salesianostriana.edu.romansdriving.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Vehiculo;
import com.salesianostriana.edu.romansdriving.repository.VehiculoRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class VehiculoService extends BaseServiceImpl<Vehiculo,Long,VehiculoRepository> {

    public boolean comprobarAntiguedadVehiculo(Vehiculo vehiculo){

        if(vehiculo.getAnhosAntiguedad()>0){
            return true;
        }
        else{
            return false;
        }
    }
}
