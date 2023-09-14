package com.project.facereconhecimento.repository;

import com.project.facereconhecimento.model.Controlador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControladorRepository extends JpaRepository<Controlador,Long> {
}
