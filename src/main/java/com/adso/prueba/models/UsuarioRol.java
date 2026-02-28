package com.adso.prueba.models;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UsuarioRol {

    @EmbeddedId// Definir claves primarias compuestas
    private UsuarioRolId id;

    private Boolean estado;
    private LocalDate fechaCreacion;

    @ManyToOne
    @MapsId("iduser")
    private Usuario usuario;
    @ManyToOne
    @MapsId("idRol")
    private Rol rol;

}
