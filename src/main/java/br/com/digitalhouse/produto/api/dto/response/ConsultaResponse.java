package br.com.digitalhouse.produto.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
public class ConsultaResponse {
    private UUID id;
    private UUID paciente_id;
    private UUID dentista_id;
    private Date dataConsulta;
    private Date created_at;
    private Date updated_at;
    private String descricao;
}
