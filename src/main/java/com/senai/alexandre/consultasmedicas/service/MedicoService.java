package com.senai.alexandre.consultasmedicas.service;

import com.senai.alexandre.consultasmedicas.model.Medico;
import com.senai.alexandre.consultasmedicas.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico save(Medico medico){
        return this.medicoRepository.save(medico);
    }

    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }

    public Medico update(Medico medico){
        return this.save(medico);
    }

    public void delete(Integer id){
        this.medicoRepository.deleteById(id);
    }

}