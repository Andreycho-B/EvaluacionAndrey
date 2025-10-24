package com.evaluacion.andrey.repository;

import com.evaluacion.andrey.entity.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
    List<Profesional> findByEspecialidad(String especialidad);
}