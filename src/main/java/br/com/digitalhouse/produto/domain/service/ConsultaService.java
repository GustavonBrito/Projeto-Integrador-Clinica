package br.com.digitalhouse.produto.domain.service;

import br.com.digitalhouse.produto.domain.entity.Consulta;

import java.util.List;
import java.util.UUID;

public interface ConsultaService {
    Consulta createConsulta(Consulta consulta);
    Consulta updateConsulta(Consulta consulta);
    Consulta readConsulta(UUID id);
    List<Consulta> readAllConsultas();
    void deleteConsulta(UUID id);
}
