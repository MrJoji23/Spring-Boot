package com.adso.prueba.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductoDto {
    private Long id_producto;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private String descripcion;
    private Boolean disponible;
}
