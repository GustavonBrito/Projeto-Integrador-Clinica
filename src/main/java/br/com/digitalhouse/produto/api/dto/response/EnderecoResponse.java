package br.com.digitalhouse.produto.api.dto.response;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class EnderecoResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String logradouro;
    private String bairro;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String cidade;
    private String estado;
    private String cep;
}
