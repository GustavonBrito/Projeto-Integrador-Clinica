package br.com.digitalhouse.produto.api.dto.openapi;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
public class PageParamsClinicaResponse {
    private List<ClinicaResponse> content;
    @Schema(example = "1")
    private Integer size;
    @Schema(example = "10")
    private Integer totalElements;
    @Schema(example = "1")
    private Integer totalPage;
    private Integer number;

    @Data
    public static class ClinicaResponse{

        private UUID id;
        @Schema(example = "Clinica Dentes Brancos")
        private String nome;
        @Schema(example = "CNPJ Valido aqui")
        private String cnpj;
        @Schema(example = "Clinica Dentes Brancos")
        private String razao_social;
        @Schema(example = "Clinica especializada em tratamento para embranquecer os dentes.")
        private String descricao;
        private Instant created_at;
        private Instant updated_at;
        private EnderecoResponseApi endereco;
        private ContatoResponseApi contato;
    }
}
