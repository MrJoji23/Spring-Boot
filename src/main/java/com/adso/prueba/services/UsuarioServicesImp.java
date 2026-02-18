package com.adso.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.prueba.dtos.UsuarioDto;
import com.adso.prueba.mappers.UsuarioMapper;
import com.adso.prueba.models.Usuario;
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
// verificacion del metodo enseguida este funcionando bien
    @Override
    public UsuarioDto saveUser(UsuarioDto usuarioDto){// Hago llamado de como lo llame en el service 
        Usuario usuario = usuarioMapper.toUsuario(usuarioDto); // Nuevo objeto recibe de modelo y pasa a modelo
        return usuarioMapper.toUsuarioDto(userepo.save(usuario)); // Retorna el modelo y guarda el dto
    }

}
