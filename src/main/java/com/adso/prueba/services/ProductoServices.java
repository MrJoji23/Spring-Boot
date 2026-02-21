package com.adso.prueba.services;

import java.util.List;

import com.adso.prueba.dtos.ProductoDto;


public interface ProductoServices {

    public List<ProductoDto> getProductos(); //Obtener una lista de productos en formato DTO en toda la BD

    public ProductoDto saveProducto(ProductoDto productoDto); // Guardar un nuevo producto en la base de datos, recibiendo un DTO con los datos del producto a guardar
                            // Recibe dto   Guarda el dto

    public ProductoDto buscarId(Long id); // metodo para buscar un producto por su ID

    public ProductoDto eliminarProducto(Long id); // metodo para eliminar un producto por su ID

    public ProductoDto actualizarProducto(Long id, ProductoDto productoDto);
}
 