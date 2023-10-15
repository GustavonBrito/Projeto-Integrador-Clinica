package br.com.digitalhouse.produto.domain.service;

import br.com.digitalhouse.produto.domain.entity.Clinica;

import java.util.List;
import java.util.UUID;

public interface ClinicaService {
    Clinica createClinica(Clinica clinica);
    Clinica updateClinica(Clinica clinica);
    Clinica readClinicabyId(UUID id);
    Clinica readClinicabyName(String nome);
    List<Clinica>readAllClinicas();
    void deleteClinica(UUID id);
}
