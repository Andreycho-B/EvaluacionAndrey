package com.evaluacion.andrey.service;

import com.evaluacion.andrey.entity.Cita;
import com.evaluacion.andrey.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {
    
    @Autowired
    private CitaRepository citaRepository;
    
    public List<Cita> findAll() {
        return citaRepository.findAll();
    }
    
    public Optional<Cita> findById(Long id) {
        return citaRepository.findById(id);
    }
    
    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }
    
    public void deleteById(Long id) {
        citaRepository.deleteById(id);
    }
    
    public List<Cita> findByUsuarioId(Long usuarioId) {
        return citaRepository.findByUsuarioId(usuarioId);
    }
    
    public List<Cita> findByProfesionalId(Long profesionalId) {
        return citaRepository.findByProfesionalId(profesionalId);
    }
}