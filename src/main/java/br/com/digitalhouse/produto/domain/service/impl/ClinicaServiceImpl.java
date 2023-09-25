package br.com.digitalhouse.produto.domain.service.impl;

import br.com.digitalhouse.produto.domain.entity.Clinica;
import br.com.digitalhouse.produto.domain.repository.ClinicaRepository;
import br.com.digitalhouse.produto.domain.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicaServiceImpl implements ClinicaService {


    private ClinicaRepository clinicaRepository;
    @Autowired
    public void ClinicaServiceImpl(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }
    @Override
    public Clinica createClinica(Clinica clinica) {
        return this.clinicaRepository.save(clinica);
    }

    @Override
    public Clinica updateClinica(Clinica clinica) {
        return this.clinicaRepository.save(clinica);
    }

    @Override
    public Clinica readClinica(UUID id) {
        return this.clinicaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Clinica> readAllClinicas() {
        return this.clinicaRepository.findAll();
    }

    @Override
    public void deleteClinica(UUID id) {
        this.clinicaRepository.deleteById(id);
    }
}
