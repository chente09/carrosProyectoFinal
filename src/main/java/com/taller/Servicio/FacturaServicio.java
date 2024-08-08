package com.taller.Servicio;

import com.taller.Entidad.Carros;
import com.taller.Entidad.Factura;
import com.taller.Repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    public List<Carros> buscarCarrosPorFactura(String numeroFactura){
        return facturaRepositorio.findByNumeroFactura(numeroFactura).stream()
                .map(Factura::getCarros)
                .collect(Collectors.toList());
    }
}
