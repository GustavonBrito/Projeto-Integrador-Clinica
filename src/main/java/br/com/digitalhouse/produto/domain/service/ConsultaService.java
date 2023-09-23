package br.com.digitalhouse.produto.domain.service;

import br.com.digitalhouse.produto.domain.entity.Consulta;
import br.com.digitalhouse.produto.domain.repository.ConsultaRepository;
import br.com.digitalhouse.produto.domain.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaService implements ConsultaServiceImpl {
    private ConsultaRepository consultaService;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
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
    public List<Consulta> readConsultas() {
        return this.consultaService.findAll();
    }

    @Override
    public void deleteConsulta(UUID id) {
        this.consultaService.deleteById(id);
    }
}
