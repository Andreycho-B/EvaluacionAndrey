package com.evaluacion.andrey.controller;

import com.evaluacion.andrey.entity.Servicio;
import com.evaluacion.andrey.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
    
    @Autowired
    private ServicioService servicioService;
    
    @GetMapping
    public String listarServicios(Model model) {
        List<Servicio> servicios = servicioService.findAll();
        model.addAttribute("servicios", servicios);
        return "servicios/lista";
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicios/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarServicio(@ModelAttribute Servicio servicio) {
        servicioService.save(servicio);
        return "redirect:/servicios";
    }
}