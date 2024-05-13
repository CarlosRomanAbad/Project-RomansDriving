package com.salesianostriana.edu.romansdriving.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Profesor;
import com.salesianostriana.edu.romansdriving.repository.ProfesorRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class ProfesorService extends BaseServiceImpl<Profesor,Long,ProfesorRepository> {

}
