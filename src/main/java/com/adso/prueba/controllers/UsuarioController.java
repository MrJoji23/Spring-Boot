package com.adso.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.prueba.dtos.UsuarioDto;
import com.adso.prueba.models.Usuario;
import com.adso.prueba.repositories.UsuarioRepository;
import com.adso.prueba.services.UsuarioServices;

@RestController
@RequestMapping("/api/users") // El inicio de la URL
public class UsuarioController {

 //Repositorios
private final UsuarioRepository usrepo;
public UsuarioController(UsuarioRepository usrepo) {
    this.usrepo = usrepo;
}
@GetMapping("/")
public String inicio() {
    return new String("Saluo desde Spring Boot");
}
// Leer todos los datos
@GetMapping("/users")
public List<Usuario> ListaUsers() {
    return usrepo.findAll();
}
// Consulta por ID
@GetMapping("/{id}")
public Usuario ObtenerUsuarioId(@PathVariable Long id) {
    return usrepo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
}
// agregar usuario
//nosotros le damos el modelo y lo pasamos a DTO y lo sacamos en modelo
@PostMapping("/crear")
public Usuario CrearUsuario(@RequestBody Usuario usuario) {
    return usrepo.save(usuario);
}
    //@Autowired es inyeccion de depedencias
    @Autowired UsuarioServices usuarioServices;

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDto>> todosusuarios() {
        return new ResponseEntity<>(usuarioServices.getUsuarios(), HttpStatus.OK); //Respuesta HTTP OK
    }
    
// Ahora lo hacemos al contrario ingresando un dto y enviando un modelo 

    @PostMapping("/guardar")
    public ResponseEntity<UsuarioDto> guardarusuario(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuarioServices.saveUser(usuarioDto), HttpStatus.CREATED);

    }



}