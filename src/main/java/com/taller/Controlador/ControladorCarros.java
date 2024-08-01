package com.taller.Controlador;

import com.taller.Entidad.Carros;
import com.taller.Servicio.CarrosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ControladorCarros {

    @Autowired
    CarrosServicio carrosServicio;

    //LEER
    @GetMapping("/carros")
    public String mostrarProductos(Model model){
        List<Carros> carros = carrosServicio.listarCarros();
        model.addAttribute("carros", carros);
        return "/Producto/listaPrductos";
    }

    //CREAR
    @GetMapping("/formulario")
    public String formularioCarro(Model model){
        model.addAttribute("carros", new Carros());
        return "/Producto/formulario";
    }

    @PostMapping("/guardar")
    public String crearCarro(Carros carros){
        carrosServicio.guadarCarros(carros);
        return "redirect:/carros";
    }


    //ACTUALIZAR
    @GetMapping("/editar/{id}")
    public String actualizarCarro(@PathVariable Long id, Model model){
        Optional<Carros> carros = carrosServicio.buscarCarros(id);
        model.addAttribute("carros", carros);
        return "/Carros/formulario";
    }

    //ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String borrarCarros(@PathVariable Long id){
        carrosServicio.eliminarCarros(id);
        return "redirect:/carros";
    }
}
