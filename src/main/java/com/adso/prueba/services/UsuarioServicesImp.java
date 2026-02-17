package com.adso.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.prueba.dtos.UsuarioDto;
import com.adso.prueba.mappers.UsuarioMapper;
import com.adso.prueba.repositories.UsuarioRepository;

@Service
public class UsuarioServicesImp implements UsuarioServices {

    // Inyeccion de dependencias
    @Autowired // Conexion a el repositorio
    private UsuarioRepository userepo;

    @Autowired // Conexion a el mapeo
    private UsuarioMapper usuarioMapper;
    
    @Override
    public List<UsuarioDto> getUsuarios(){
        return  usuarioMapper.toUsuariosDto(userepo.findAll());
    }

}
