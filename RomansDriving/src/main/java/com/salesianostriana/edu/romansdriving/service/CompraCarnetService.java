package com.salesianostriana.edu.romansdriving.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.CompraCarnet;
import com.salesianostriana.edu.romansdriving.model.FechasPK;
import com.salesianostriana.edu.romansdriving.repository.CompraCarnetRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class CompraCarnetService extends BaseServiceImpl<CompraCarnet, FechasPK, CompraCarnetRepository> {

}
