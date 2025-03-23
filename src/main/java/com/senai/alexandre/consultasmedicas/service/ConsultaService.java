package com.senai.alexandre.consultasmedicas.service;

import com.senai.alexandre.consultasmedicas.model.Consulta;
import com.senai.alexandre.consultasmedicas.model.StatusConsulta;
import com.senai.alexandre.consultasmedicas.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta findById(int id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public void agendarConsulta(Consulta consulta) {
        if (consultaRepository.existsByPacienteAndDataAndHorario(consulta.getPaciente(), consulta.getDataConsulta(), consulta.getHorarioConsulta())) {
            throw new RuntimeException("O paciente já tem uma consulta agendada para esse horário!");
        }
        consulta.setStatus(StatusConsulta.AGENDADA);
        consultaRepository.save(consulta);
    }

    public void cancelarConsulta(Integer id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        if (consulta.getStatus() == StatusConsulta.REALIZADA) {
            throw new RuntimeException("Não é possível cancelar uma consulta já realizada.");
        }
        consulta.setStatus(StatusConsulta.CANCELADA);
        consultaRepository.save(consulta);
    }

    public void concluirConsulta(Integer id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        if (consulta.getStatus() == StatusConsulta.CANCELADA) {
            throw new RuntimeException("Não é possível concluir uma consulta cancelada.");
        }

        if (consulta.getDataConsulta().isAfter(LocalDate.now()) ||
                (consulta.getDataConsulta().isEqual(LocalDate.now()) && consulta.getHorarioConsulta().isAfter(LocalTime.now()))) {
            throw new RuntimeException("Não é possível concluir uma consulta antes do horário.");
        }

        consulta.setStatus(StatusConsulta.REALIZADA);
        consultaRepository.save(consulta);
    }
}