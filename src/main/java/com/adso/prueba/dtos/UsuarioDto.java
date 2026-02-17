package com.adso.prueba.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDto {
    private Long id_usuario;
    private String nombre;
    private String correo;

}
