package br.com.digitalhouse.produto.domain.service.impl;

import br.com.digitalhouse.produto.domain.entity.Consulta;
import br.com.digitalhouse.produto.domain.repository.ConsultaRepository;
import br.com.digitalhouse.produto.domain.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    private ConsultaRepository consultaService;

    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaService) {
        this.consultaService = consultaService;
    }

    @Override
    public Consulta createConsulta(Consulta consulta) {
        return this.consultaService.save(consulta);
    }

    @Override
    public Consulta updateConsulta(Consulta consulta) {
        return this.consultaService.save(consulta);
    }

    @Override
    public Consulta readConsulta(UUID id) {
        return this.consultaService.findById(id).orElseThrow();
    }

    @Override
    public List<Consulta> readAllConsultas() {
        return this.consultaService.findAll();
    }

    @Override
    public void deleteConsulta(UUID id) {
        this.consultaService.deleteById(id);
    }
}