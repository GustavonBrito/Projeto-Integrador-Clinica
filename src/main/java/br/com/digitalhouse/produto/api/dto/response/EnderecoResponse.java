package br.com.digitalhouse.produto.api.dto.response;


import br.com.digitalhouse.produto.domain.entity.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoResponse {

    private Endereco endereco;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID id;
//    private String logradouro;
//    private String bairro;
//    private String cidade;
//    private String estado;
//    private String cep;


//    public EnderecoResponse(Endereco endereco) {
//        this.endereco = endereco;
//    }
}
