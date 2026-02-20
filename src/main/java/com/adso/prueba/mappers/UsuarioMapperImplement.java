package com.adso.prueba.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adso.prueba.dtos.UsuarioDto;
import com.adso.prueba.models.Usuario;

@Component
public class UsuarioMapperImplement implements UsuarioMapper {

    // Declara un metodo publico para convertir un dto a un modelo
    @Override // Verificacion de un metodo bien construido
    public Usuario toUsuario(UsuarioDto usuarioDto) { // Convierte un dto a un modelo

        if (usuarioDto == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setId(usuarioDto.getId_usuario());
        usuario.setNom(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getCorreo());
        return usuario;
    }

// Declara un metodo publico para convertir un modelo a un productoDto
    @Override
    public UsuarioDto toUsuarioDto(Usuario usuario) {

        if (usuario == null) {
            return null;
        }

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId_usuario(usuario.getId());
        usuarioDto.setNombre(usuario.getNom());
        usuarioDto.setCorreo(usuario.getEmail());
        return usuarioDto;
    }



    @Override
    public List<UsuarioDto> toUsuariosDto(List<Usuario> usuarios){

        if (usuarios == null) {
            return null;
            
        }
        // Llega los datos dto y los convierte en normal 
        List<UsuarioDto> usuarioDto = new ArrayList<UsuarioDto>(usuarios.size());
        for(Usuario usuario : usuarios) {
            usuarioDto.add(toUsuarioDto(usuario));
        }
        return usuarioDto;
    }
}
