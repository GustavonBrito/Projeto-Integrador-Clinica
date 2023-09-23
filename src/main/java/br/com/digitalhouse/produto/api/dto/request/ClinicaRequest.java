package br.com.digitalhouse.produto.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class ClinicaRequest {
    @CNPJ
    private String cnpj;
    @NotBlank
    private String nome;
    @NotNull
    private String razao_social;
    private String descricao;
}
