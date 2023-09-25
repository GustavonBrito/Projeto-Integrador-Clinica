package br.com.digitalhouse.produto.api.dto.response;

import br.com.digitalhouse.produto.api.dto.request.EnderecoRequest;
import br.com.digitalhouse.produto.domain.entity.Contato;
import br.com.digitalhouse.produto.domain.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ClinicaListResponse {
    private UUID id;
    private String nome;
    private String cnpj;
    private String razao_social;
    private Endereco endereco;
    private Contato contato;
    private String descricao;
//    private Instant created_at;
//    private Instant updated_at;


}
