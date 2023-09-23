package br.com.digitalhouse.produto.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ClinicaResponse {
    private UUID id;
    private String nome;
    private String cnpj;
    private String descricao;
    private Instant created_at;
    private Instant updated_at;

}

