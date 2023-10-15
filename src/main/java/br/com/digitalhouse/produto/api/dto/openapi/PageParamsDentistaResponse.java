package br.com.digitalhouse.produto.api.dto.openapi;

import br.com.digitalhouse.produto.domain.entity.EnumSexo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class PageParamsDentistaResponse {
    private List<DentistaResponse> content;
    @Schema(example = "1")
    private Integer size;
    @Schema(example = "10")
    private Integer totalElements;
    @Schema(example = "1")
    private Integer totalPage;
    private Integer number;

    @Data
    public static class DentistaResponse {
        private UUID id;
        @Schema(example = "Valdir")
        private String nome;
        @Schema(example = "2023-10-12")
        private LocalDate data_nascimento;
        @Schema(example = "Odonto")
        private String especialidade;
        private Instant created_at;
        private Instant updated_at;
        @Schema(example = "M")
        private EnumSexo enumSexo;
    }
}
