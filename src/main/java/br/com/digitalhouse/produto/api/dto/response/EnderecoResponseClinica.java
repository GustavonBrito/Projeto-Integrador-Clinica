package br.com.digitalhouse.produto.api.dto.response;

import br.com.digitalhouse.produto.domain.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoResponseClinica {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
}
