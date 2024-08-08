package com.taller.Controlador;

import com.taller.Entidad.Empleado;
import com.taller.Servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ControladorEmpleado {
    @Autowired
    private EmpleadoServicio empleadoServicio;

    //LEER
    @GetMapping("/empleado")
    public String mostrarEmpleado(Model model){
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        model.addAttribute("empleado", empleados);
        return "/Empleado/vistaEmpleado";
    }

    //CREAR
    @GetMapping("/formularioEmpleado")
    public String formularioEmpleado(Model model){
        model.addAttribute("empleado", new Empleado());
        return "/Empleado/formularioEmpleado";
    }

    @PostMapping("/guardarEmpleado")
    public String crearEmpleado(Empleado empleado){
        empleadoServicio.guadarEmpleados(empleado);
        return "redirect:/empleado";
    }

    //ACTUALIZAR
    @GetMapping("/editarEmpleado/{id}")
    public String actualizarEmpleado(@PathVariable Long id, Model model){
        Optional<Empleado> empleado = empleadoServicio.buscarEmpleado(id);
        model.addAttribute("empleado", empleado);
        return "/Empleado/formularioEmpleado";
    }

    //ELIMINAR
    @GetMapping("/eliminarEmpleado/{id}")
    public String borrarEmpleado(@PathVariable Long id){
        empleadoServicio.eliminarEmpleado(id);
        return "redirect:/empleado";
    }

}
