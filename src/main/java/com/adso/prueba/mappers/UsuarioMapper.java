package com.adso.prueba.mappers;

import java.util.List;

import com.adso.prueba.dtos.UsuarioDto;
import com.adso.prueba.models.Usuario;


public interface UsuarioMapper {
    
    // 2.cambiar 1.Recibe
    Usuario toUsuario(UsuarioDto usuarioDto);

    UsuarioDto toUsuarioDto(Usuario usuario);
    // 2.Cambiar 1. Recibe

    List<UsuarioDto> toUsuariosDto(List<Usuario> usuarios);
    // 2.Cambiar 1. Recibe

    // void no espera nada, solo unirlos
    void updateusuario(Usuario usuario, UsuarioDto usuarioDto);
    // Metodo de actualizar el usuario, se espera el del modelo y el de dto
}
