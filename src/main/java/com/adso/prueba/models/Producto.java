package com.adso.prueba.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nomProducto;

    @Column(nullable = false)
    private Double precioProducto;

    @Column(nullable = false)
    private Integer cantidadProducto;

    @Column(length = 255)
    private String descripcionProducto;

    @Column(nullable = false)
    private Boolean disponibleProducto;
}
