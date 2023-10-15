package br.com.digitalhouse.produto.api.dto.openapi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PacienteResponseApi {
    @Schema(example = "Gustavo")
    private String nome;
}
