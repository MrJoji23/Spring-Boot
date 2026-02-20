package com.adso.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.prueba.dtos.ProductoDto;
import com.adso.prueba.mappers.ProductoMapper;
import com.adso.prueba.models.Producto;
import com.adso.prueba.repositories.ProductoRepository;

@Service
public class ProductoServicesImp implements ProductoServices {

    @Autowired // Inyeccion de dependencias
    private ProductoRepository productRepostory;

    @Autowired // Inyeccion de dependencias
    private ProductoMapper productoMapper;

    @Override // Verificacion del metodo que funcione bien
    public List<ProductoDto> getProductos() { // Convierte dto a una lista de productos
        return productoMapper.toProductosDto(productRepostory.findAll()); //devuelve todos los datos en una lista dto
    }
    @Override
    public ProductoDto saveProducto(ProductoDto productoDto) {
        Producto producto = productoMapper.toProducto(productoDto);
        return productoMapper.toProductoDto(productRepostory.save(producto));
    } //  El producto guardado lo convierte de vuelta a `ProductoDto` y lo muestra
    @Override
    public ProductoDto buscarId(Long id) {
        Producto producto = productRepostory.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado")); // Busca el producto por su ID en el repositorio(Modelo)
        return productoMapper.toProductoDto(producto); // Convierte el producto encontrado a un DTO y lo devuelve DTO
    }

    @Override
    public ProductoDto eliminarProducto(Long id) {
        Producto producto = productRepostory.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado")); // Busca el producto por su ID en el repositorio(Modelo)
        productRepostory.deleteById(id); // Elimina el producto encontrado del repositorio
        return productoMapper.toProductoDto(producto); // Devuelve el producto eliminado como DTO
}
}