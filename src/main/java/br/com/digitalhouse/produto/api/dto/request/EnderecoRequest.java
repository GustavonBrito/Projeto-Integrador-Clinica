package br.com.digitalhouse.produto.api.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class EnderecoRequest {
    private String logradouro;
    private String bairro;
//    private Instant created_at;
//    private Instant updated_at;
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String cep;

}
