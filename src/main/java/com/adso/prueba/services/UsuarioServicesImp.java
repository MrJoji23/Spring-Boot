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

    @Override// Verificacion que el metodo este bien
    public UsuarioDto BuscarId(Long id) {
        Usuario usuario = userepo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado")); // Busca el producto por su ID en el repositorio(Modelo)
        return usuarioMapper.toUsuarioDto(usuario); // Convierte el producto encontrado a un DTO y lo devuelve DTO
    }   
    
    @Override
    public UsuarioDto eliminarUsuario(Long id) {
        Usuario usuario = userepo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado")); // Busca el producto por su ID en el repositorio(Modelo)
        userepo.deleteById(id); // Elimina el producto encontrado del repositorio
        return usuarioMapper.toUsuarioDto(usuario); // Devuelve el producto eliminado como DTO
    }
    @Override
    public UsuarioDto acutalizarUsuario(Long id, UsuarioDto usuarioDto){// Metodo del actualizar del UsuarioServices
        Usuario usuario = userepo.findById(id).get();
        usuarioMapper.updateusuario(usuario, usuarioDto);
        return usuarioMapper.toUsuarioDto(userepo.save(usuario));
    }


}
