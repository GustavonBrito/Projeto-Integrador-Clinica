package br.com.digitalhouse.produto.domain.service.impl;

import br.com.digitalhouse.produto.domain.entity.Clinica;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClinicaServiceImpl {
    Clinica createClinica(Clinica clinica);
    Clinica updateClinica(Clinica clinica);
    Clinica readClinica(UUID id);
    List<Clinica>readAllClinicas();
    void deleteClinica(UUID id);
}
