package br.com.digitalhouse.produto.api.dto.openapi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class PageParamsConsultaResponse {
    private List<ConsultaResponse> content;
    @Schema(example = "1")
    private Integer size;
    @Schema(example = "10")
    private Integer totalElements;
    @Schema(example = "1")
    private Integer totalPage;
    private Integer number;

    @Data
    public static class ConsultaResponse{
        private UUID id;
        @Schema(example = "2023-10-25")
        private LocalDate dataConsulta;
        private Instant created_at;
        private Instant updated_at;
        @Schema(example = "Doutor Carlos, clareamento de dente do paciente guilherme")
        private String descricao;
        @Schema(example = "true")
        private Boolean cancelada;
        @Schema(example = "Algum motivo aqui")
        private String motivoCancelamento;

        private PacienteResponseApi paciente;
        private DentistaResponseApi dentista;
    }
}
