package com.adso.prueba.mappers;

import java.util.List;

import com.adso.prueba.dtos.ProductoDto;
import com.adso.prueba.models.Producto;

public interface ProductoMapper {
    //Recibe un modelo y lo convierte a un dto
    List<ProductoDto> toProductosDto(List<Producto> productos); 

    Producto toProducto(ProductoDto productoDto);
    // Convierte modelo        // Recibe dto

    ProductoDto toProductoDto(Producto producto);
    // Convierte dto      // Recibe modelo
}
