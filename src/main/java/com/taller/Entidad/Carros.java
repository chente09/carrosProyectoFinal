package com.taller.Entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import jakarta.validation.constraints.*;


@Data
@Entity
@Table(name = "carros")
public class Carros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "La marca es obligatoria")
    private String marca;

    @NotBlank(message = "El modelo es obligatorio")
    private String modelo;

    @NotBlank(message = "El color es obligatorio")
    private String color;

    @Size(max = 255, message = "La descripción no puede exceder 255 caracteres")
    private String descripcion;

    @NotBlank(message = "La URL de la imagen es obligatoria")
    @Pattern(regexp = "(https?://)?(www\\.)?([\\w]+\\.)+[\\w]{2,63}/?.*", message = "La URL de la imagen no es válida")
    private String img;

    @NotNull(message = "El precio es obligatorio")
    @PositiveOrZero(message = "El precio debe ser un valor positivo")
    private Double precio;

    @NotNull(message = "El stock es obligatorio")
    @PositiveOrZero(message = "El stock debe ser un valor positivo")
    private Long stock;
}
