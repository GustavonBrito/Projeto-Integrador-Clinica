package br.com.digitalhouse.produto.api.dto.response;

import br.com.digitalhouse.produto.domain.entity.EnumSexo;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class PacienteResponse {
    private UUID id;

    private String nome;

    private LocalDate data_nascimento;

    private UUID endereco_id;

    private LocalDate created_at;

    private LocalDate updated_at;

    private EnumSexo sexo;

    private UUID contato_id;
}
