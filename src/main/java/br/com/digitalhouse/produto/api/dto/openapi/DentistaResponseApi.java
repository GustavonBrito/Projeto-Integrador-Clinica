package br.com.digitalhouse.produto.api.dto.openapi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DentistaResponseApi {
    @Schema(example = "Dr.Carlos")
    private String nome;
}
