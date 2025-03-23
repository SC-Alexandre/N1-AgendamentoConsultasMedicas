package com.senai.alexandre.consultasmedicas.service;

import com.senai.alexandre.consultasmedicas.model.Paciente;
import com.senai.alexandre.consultasmedicas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente save(Paciente paciente){
        return this.pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Paciente update(Paciente paciente){
        return this.save(paciente);
    }

    public void delete(Integer id){
        this.pacienteRepository.deleteById(id);
    }
}
