package com.evaluacion.andrey.controller;

import com.evaluacion.andrey.entity.Profesional;
import com.evaluacion.andrey.entity.Usuario;
import com.evaluacion.andrey.service.ProfesionalService;
import com.evaluacion.andrey.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/profesionales")
public class ProfesionalController {
    
    @Autowired
    private ProfesionalService profesionalService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public String listarProfesionales(Model model) {
        List<Profesional> profesionales = profesionalService.findAll();
        model.addAttribute("profesionales", profesionales);
        return "profesionales/lista";
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("profesional", new Profesional());
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "profesionales/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarProfesional(@ModelAttribute Profesional profesional) {
        profesionalService.save(profesional);
        return "redirect:/profesionales";
    }
}