package com.adso.prueba.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Embeddable // Verificar que el usuario no este relacionado con el proyecto
@Data
public class EmpleadoProyectoId implements Serializable{// Verificar que no se repitan(Serializable@A@)

    private Long empleadoId;
    private Long proyectoId;


}
