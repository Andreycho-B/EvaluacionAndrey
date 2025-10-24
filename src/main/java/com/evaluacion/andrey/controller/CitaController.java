package com.evaluacion.andrey.controller;

import com.evaluacion.andrey.entity.Cita;
import com.evaluacion.andrey.entity.Usuario;
import com.evaluacion.andrey.entity.Servicio;
import com.evaluacion.andrey.entity.Profesional;
import com.evaluacion.andrey.service.CitaService;
import com.evaluacion.andrey.service.UsuarioService;
import com.evaluacion.andrey.service.ServicioService;
import com.evaluacion.andrey.service.ProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/citas")
public class CitaController {
    
    @Autowired
    private CitaService citaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private ServicioService servicioService;
    
    @Autowired
    private ProfesionalService profesionalService;
    
    @GetMapping
    public String listarCitas(Model model) {
        List<Cita> citas = citaService.findAll();
        model.addAttribute("citas", citas);
        return "citas/lista";
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("cita", new Cita());
        
        List<Usuario> usuarios = usuarioService.findAll();
        List<Servicio> servicios = servicioService.findAll();
        List<Profesional> profesionales = profesionalService.findAll();
        
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("servicios", servicios);
        model.addAttribute("profesionales", profesionales);
        
        return "citas/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute Cita cita) {
        cita.setEstado("PENDIENTE"); // Estado por defecto
        citaService.save(cita);
        return "redirect:/citas";
    }
}