package br.com.digitalhouse.produto.domain.service.impl;

import br.com.digitalhouse.produto.domain.entity.Paciente;

import java.util.List;
import java.util.UUID;

public interface PacienteServiceImpl {
    Paciente createPaciente(Paciente paciente);
    Paciente updatePaciente(Paciente paciente);
    Paciente readPaciente(UUID id);
    List<Paciente> readPacientes();
    void deletePaciente(UUID id);
}
