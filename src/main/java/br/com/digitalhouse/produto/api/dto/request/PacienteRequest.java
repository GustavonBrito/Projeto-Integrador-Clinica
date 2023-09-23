package br.com.digitalhouse.produto.api.dto.request;

import br.com.digitalhouse.produto.domain.entity.EnumSexo;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PacienteRequest {
    @NotNull
    private String nome;
    @NotNull
    private LocalDate data_nascimento;
    @NotNull
    private EnumSexo sexo;


}
