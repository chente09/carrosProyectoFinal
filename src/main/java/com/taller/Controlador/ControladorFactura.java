package com.taller.Controlador;

import com.taller.Entidad.Carros;
import com.taller.Servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControladorFactura {
    @Autowired
    FacturaServicio facturaServicio;

    @GetMapping("/facturas")
    public String buscarProductosByFactura(@RequestParam(value = "numeroFactura", required= false) String numeroFactura, Model model){
        if(numeroFactura!=null && !numeroFactura.isEmpty()){
            List<Carros> carros=facturaServicio.buscarCarrosPorFactura(numeroFactura);
            model.addAttribute("carros", carros);
        }
        return "Factura/vistaFactura";
    }
}
