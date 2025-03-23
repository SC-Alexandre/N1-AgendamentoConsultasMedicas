package com.senai.alexandre.consultasmedicas.repository;

import com.senai.alexandre.consultasmedicas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
