package br.com.digitalhouse.produto.api.dto.response;

import br.com.digitalhouse.produto.domain.entity.EnumSexo;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class DentistaResponse {
    private UUID id;
    private String nome;
    private LocalDate data_nascimento;
    private String especialidade;
    private Instant created_at;
    private Instant updated_at;
    private EnumSexo enumSexo;
}
