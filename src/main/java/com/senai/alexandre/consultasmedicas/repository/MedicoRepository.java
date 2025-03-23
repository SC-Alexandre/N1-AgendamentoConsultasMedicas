package com.senai.alexandre.consultasmedicas.repository;

import com.senai.alexandre.consultasmedicas.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
