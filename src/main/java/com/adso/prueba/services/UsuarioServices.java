package com.adso.prueba.services;

import java.util.List;

import com.adso.prueba.dtos.UsuarioDto;

public interface UsuarioServices {

    public List<UsuarioDto> getUsuarios();

    public UsuarioDto saveUser(UsuarioDto usuarioDto);
                            // Recibe dto   Guarda el dto
    
}
