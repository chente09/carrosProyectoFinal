package com.taller.Entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "carros")
public class Carros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String marca;
    private String modelo;
    private String color;
    private String descripcion;
    private String img;
    private Double precio;
    private Long stock;
}

