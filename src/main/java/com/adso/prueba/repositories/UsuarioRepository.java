package com.adso.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adso.prueba.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
