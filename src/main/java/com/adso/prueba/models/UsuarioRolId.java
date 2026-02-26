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

    @Override
    public boolean equals(Object o){
        //Implementacion
    }
    @Override
    public int hashCode(){//Hashcode es comparar de que el id ya no este, y no repiten los datos en la llave primaria
        //Implementacion
    }

}
