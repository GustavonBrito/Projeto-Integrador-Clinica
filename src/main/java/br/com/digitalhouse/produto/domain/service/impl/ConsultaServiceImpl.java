package br.com.digitalhouse.produto.domain.service.impl;

import br.com.digitalhouse.produto.domain.entity.Consulta;

import java.util.List;
import java.util.UUID;

public interface ConsultaServiceImpl {
    Consulta createConsulta(Consulta consulta);
    Consulta updateConsulta(Consulta consulta);
    Consulta readConsulta(UUID id);
    List<Consulta> readConsultas();
    void deleteConsulta(UUID id);
}
