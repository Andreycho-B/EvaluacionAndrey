package com.evaluacion.andrey.repository;

import com.evaluacion.andrey.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByUsuarioId(Long usuarioId);
    List<Cita> findByProfesionalId(Long profesionalId);
    List<Cita> findByEstado(String estado);
}