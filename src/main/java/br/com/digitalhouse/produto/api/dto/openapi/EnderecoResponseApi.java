package br.com.digitalhouse.produto.api.dto.openapi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EnderecoResponseApi {
    @Schema(example = "Horto do Ipe")
    private String logradouro;
    @Schema(example = "Jardim sao Luiz")
    private String bairro;
    @Schema(example = "Sao Paulo")
    private String cidade;
    @Schema(example = "Sao Paulo")
    private String estado;
    @Schema(example = "058-6364")
    private String cep;
}
