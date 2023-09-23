package br.com.digitalhouse.produto.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
public class ConsultaRequest {
    @NotNull
    private Date dataConsulta;
    @NotNull
    private String descricao;
    private Boolean cancelada;
    private String motivoCancelamento;

}
