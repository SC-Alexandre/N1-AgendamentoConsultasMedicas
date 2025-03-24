package com.senai.alexandre.consultasmedicas.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private LocalDate dataConsulta; // yyyy-MM-dd

    @Column
    private LocalTime horarioConsulta; // HH:mm:ss

    @Enumerated(EnumType.STRING) // Armazenar como string no banco de dados
    private StatusConsulta status;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @OneToOne
    @JoinColumn(name = "paciente_id", unique = true, nullable = false)
    private Paciente paciente;

    public Consulta() {
    }

    public Consulta(Integer id, LocalDate dataConsulta, LocalTime horarioConsulta, StatusConsulta status, Medico medico, Paciente paciente) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.status = status;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalTime getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(LocalTime horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
