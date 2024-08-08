package com.taller.Entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFactura;
    private Double precio;
    private Date fecha;
    private String observaciones;


    @ManyToOne
    @JoinColumn(name="id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name="id_carros")
    private Carros carros;
}
