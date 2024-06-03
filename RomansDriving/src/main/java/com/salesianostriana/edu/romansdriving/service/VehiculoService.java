package com.salesianostriana.edu.romansdriving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.Vehiculo;
import com.salesianostriana.edu.romansdriving.repository.ClaseRepository;
import com.salesianostriana.edu.romansdriving.repository.VehiculoRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class VehiculoService extends BaseServiceImpl<Vehiculo,Long,VehiculoRepository> {


    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ClaseRepository claseRepository;


    private Clase clase;

    public boolean comprobarAntiguedadVehiculo(Vehiculo vehiculo){

        if(vehiculo.getAnhosAntiguedad()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public void borrarVehiculo(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehiculo no encontrado"));
        List<Clase> clases = claseRepository.findAll();

        boolean encontrado = false;
		for (Clase listaClases : clases) {
			if(listaClases.getVehiculo()==null){
				continue;
			}

			if(listaClases.getVehiculo().getNumBastidor()==vehiculo.getNumBastidor()){
				encontrado = true;
			}
		}

		if(encontrado){
			clase.removeFromClaseVehiculo(vehiculo);
		}
        
       
        vehiculoRepository.deleteById(id);
    }
}
