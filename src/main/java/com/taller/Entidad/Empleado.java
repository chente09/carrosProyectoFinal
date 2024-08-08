package com.taller.Entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String cedula;
    private String

}
