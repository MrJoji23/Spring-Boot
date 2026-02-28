package com.adso.prueba.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor//genera un constructor con todos los campos de la clase como parámetros. //Usuario u = new Usuario(1L, "Carlos", "carlos@email.com");
@Embeddable//Verifica que el rol no este creado
@Data//Para generar un consulta rapida de get y sett rapido
public class UsuarioRolId implements Serializable {// Verificar que no se repitan(Serializable@A@)

    private Long iduser;
    private Byte idRol;



}
