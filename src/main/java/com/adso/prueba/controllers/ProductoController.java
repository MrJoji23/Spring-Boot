package com.adso.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.prueba.dtos.ProductoDto;
import com.adso.prueba.services.ProductoServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api")

public class ProductoController {

    // Uso de servicios para obtener datos como DTO
    @Autowired
    private ProductoServices productoServices;

    @GetMapping("/mostrar-productos")
    public ResponseEntity<List<ProductoDto>> todoproductos() {
        return new ResponseEntity<>(productoServices.getProductos(), HttpStatus.OK);
    }
    @PostMapping("/guardar")
    public ResponseEntity<ProductoDto> guardarproducto(@RequestBody ProductoDto usuariDto) {
        return new ResponseEntity<>(productoServices.saveProducto(usuariDto), HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductoDto> obtenerProductoId(@PathVariable Long id  ) {
        return new ResponseEntity<>(productoServices.buscarId(id), HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ProductoDto> eliminarProducto(@PathVariable Long id){
        return new ResponseEntity<>(productoServices.eliminarProducto(id), HttpStatus.OK);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<ProductoDto> updateProduct(@PathVariable Long id, @RequestBody ProductoDto productoDto) {
        return new ResponseEntity<>(productoServices.actualizarProducto(id, productoDto), HttpStatus.OK);
    }
}

