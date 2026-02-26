package com.adso.prueba.models;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data//Crear y consultar
@Entity

public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Long id;

    @Column
    private String nom;

    @Column
    private String ape;

    @Column
    private String tel;
    
    @ManyToOne(fetch = FetchType.EAGER)// Es una carga inmediata
    @JoinColumn(name = "cargo_id", nullable = false, foreignKey = @ForeignKey(name = "Fk_Empleado_cargo"))
    private Cargo cargo;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EmpleadoProyeco> asignaciones = new ArrayList<>();

}
