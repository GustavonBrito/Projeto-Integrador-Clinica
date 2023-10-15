package br.com.digitalhouse.produto.api.dto.response;


import br.com.digitalhouse.produto.domain.entity.Dentista;
import br.com.digitalhouse.produto.domain.entity.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
public class ConsultaListResponse {
    private UUID id;
    private LocalDate dataConsulta;
    private Instant created_at;
    private Instant updated_at;
    private String descricao;
    private Boolean cancelada;
    private String motivoCancelamento;
//    private Clinica clinica;
    private Dentista dentista;
    private Paciente paciente;
}