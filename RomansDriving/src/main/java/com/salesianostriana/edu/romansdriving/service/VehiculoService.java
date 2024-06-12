package com.salesianostriana.edu.romansdriving.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Clase;
import com.salesianostriana.edu.romansdriving.model.Profesor;
import com.salesianostriana.edu.romansdriving.model.Vehiculo;
import com.salesianostriana.edu.romansdriving.repository.ClaseRepository;
import com.salesianostriana.edu.romansdriving.repository.VehiculoRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class VehiculoService extends BaseServiceImpl<Vehiculo,Long,VehiculoRepository> {


    @Autowired
    private VehiculoRepository vehiculoRepository;

   // @Autowired
  //  private ClaseRepository claseRepository;


  //  private Clase clase;

    public boolean comprobarAntiguedadVehiculo(Vehiculo vehiculo){

        if(vehiculo.getAnhosAntiguedad()>0){
            return true;
        }
        else{
            return false;
        }
    }

   public boolean comprobarVehiculoTieneClase(Long id) {
	   Optional<Vehiculo> vehiculoBuscado = vehiculoRepository.findById(id);
	   Vehiculo vehiculo= vehiculoBuscado.get();

		if (vehiculo.getClases() != null && !vehiculo.getClases().isEmpty()) {

			return true;

		} else {
			return false;
		}
   }
}
