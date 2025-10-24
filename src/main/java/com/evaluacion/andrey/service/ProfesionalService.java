package com.evaluacion.andrey.service;

import com.evaluacion.andrey.entity.Profesional;
import com.evaluacion.andrey.repository.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesionalService {
    
    @Autowired
    private ProfesionalRepository profesionalRepository;
    
    public List<Profesional> findAll() {
        return profesionalRepository.findAll();
    }
    
    public Optional<Profesional> findById(Long id) {
        return profesionalRepository.findById(id);
    }
    
    public Profesional save(Profesional profesional) {
        return profesionalRepository.save(profesional);
    }
    
    public void deleteById(Long id) {
        profesionalRepository.deleteById(id);
    }
    
    public List<Profesional> findByEspecialidad(String especialidad) {
        return profesionalRepository.findByEspecialidad(especialidad);
    }
}