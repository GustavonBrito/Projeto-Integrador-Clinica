package br.com.digitalhouse.produto.api.dto.openapi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ContatoResponseApi {
    @Schema(example = "email@hotmail.com")
    private String email;
    @Schema(example = "5851-9932")
    private String telefone;
}
