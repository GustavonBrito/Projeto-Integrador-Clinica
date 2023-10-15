package br.com.digitalhouse.produto.api.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClinicaRequest {
    @CNPJ
    private String cnpj;
    @NotBlank
    private String nome;
    @NotBlank
    private String razao_social;
    @NotBlank
    private String descricao;

    private EnderecoRequest enderecoRequest;
    private ContatoRequest contatoRequest;
}
