package br.com.digitalhouse.produto.api.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultaRequest {
    private LocalDate dataConsulta;
    @NotBlank
    private String descricao;
    private Boolean cancelada;
    @NotBlank
    private String motivoCancelamento;
    private DentistaRequest dentista;
    private PacienteRequest paciente;

}
