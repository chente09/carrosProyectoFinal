package com.taller.Entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFactura;

    @NotNull(message = "EL precio es obligatorio")
    private Double precio;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;


    private String observaciones;


    @ManyToOne
    @JoinColumn(name="id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name="id_carros")
    private Carros carros;
}
