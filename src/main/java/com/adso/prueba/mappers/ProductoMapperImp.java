package com.adso.prueba.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adso.prueba.dtos.ProductoDto;
import com.adso.prueba.models.Producto;

@Component
public class ProductoMapperImp implements ProductoMapper {

// Declara un metodo publico para convertir un modelo a un dto
    public ProductoDto toProductoDto(Producto producto) {
        if (producto == null) {
            return null;
        }
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId_producto(producto.getId());
        productoDto.setNombre(producto.getNomProducto());
        productoDto.setPrecio(producto.getPrecioProducto());
        productoDto.setCantidad(producto.getCantidadProducto());
        productoDto.setDescripcion(producto.getDescripcionProducto());
        productoDto.setDisponible(producto.getDisponibleProducto());
        return productoDto;
    }
//Declaracion de un metodo publico para convertir un dto a un modelo
    public Producto toProducto(ProductoDto productoDto) {
        if (productoDto == null) {
            return null;
        }
        Producto producto = new Producto();
        producto.setId(productoDto.getId_producto());
        producto.setNomProducto(productoDto.getNombre());
        producto.setPrecioProducto(productoDto.getPrecio());
        producto.setCantidadProducto(productoDto.getCantidad());
        producto.setDescripcionProducto(productoDto.getDescripcion());
        producto.setDisponibleProducto(productoDto.getDisponible());
        return producto;
    }
// Convierte una lista de Productos a una lista de ProductoDto
    @Override
    public List<ProductoDto> toProductosDto(List<Producto> productos) {
        if (productos == null) {
            return null;
        }
        List<ProductoDto> productoDto = new ArrayList<ProductoDto>(productos.size());// Crea una lista vacia donde se guardaran los ProductoDto convertidos
        for (Producto producto : productos) {// va una por una y la recorre convierte modelo a dto
            productoDto.add(toProductoDto(producto));
        }
        return productoDto;
    }
    @Override
    public void updateproducto(Producto producto, ProductoDto productoDto){
        if (producto == null) {
            return;
        }
        producto.setId(productoDto.getId_producto());
        producto.setNomProducto(productoDto.getNombre());
        producto.setPrecioProducto(productoDto.getPrecio());
        producto.setCantidadProducto(productoDto.getCantidad());
        producto.setDescripcionProducto(productoDto.getDescripcion());
        producto.setDisponibleProducto(productoDto.getDisponible());
    }
}
