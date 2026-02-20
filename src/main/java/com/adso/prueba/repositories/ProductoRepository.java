package com.adso.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adso.prueba.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
