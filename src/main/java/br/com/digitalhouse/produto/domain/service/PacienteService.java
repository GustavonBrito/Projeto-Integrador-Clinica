package br.com.digitalhouse.produto.domain.service;

import br.com.digitalhouse.produto.domain.entity.Paciente;
import br.com.digitalhouse.produto.domain.repository.PacienteRespository;
import br.com.digitalhouse.produto.domain.service.impl.PacienteServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PacienteService implements PacienteServiceImpl {

    PacienteRespository pacienteRespository;

    PacienteService(PacienteRespository pacienteRespository){
        this.pacienteRespository = pacienteRespository;
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        return this.pacienteRespository.save(paciente);
    }

    @Override
    public Paciente updatePaciente(Paciente paciente) {
        return this.pacienteRespository.save(paciente);
    }

    @Override
    public Paciente readPaciente(UUID id) {
        return this.pacienteRespository.findById(id).orElseThrow();
    }

    @Override
    public List<Paciente> readPacientes() {
        return this.pacienteRespository.findAll();
    }

    @Override
    public void deletePaciente(UUID id) {
        this.pacienteRespository.deleteById(id);
    }
}

