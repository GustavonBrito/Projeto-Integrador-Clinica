package br.com.digitalhouse.produto.api.dto.request;

import br.com.digitalhouse.produto.domain.entity.Dentista;
import br.com.digitalhouse.produto.domain.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
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

    private Paciente paciente;

    private Dentista dentista;
}
