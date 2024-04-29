package com.salesianostriana.edu.romansdriving.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.edu.romansdriving.model.Usuario;
import com.salesianostriana.edu.romansdriving.repository.UsuarioRepository;
import com.salesianostriana.edu.romansdriving.service.base.BaseService;
import com.salesianostriana.edu.romansdriving.service.base.BaseServiceImpl;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario,Long,UsuarioRepository>  {

	

}
