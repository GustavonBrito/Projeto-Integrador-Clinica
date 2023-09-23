package br.com.digitalhouse.produto.api.dto.response;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
public class ContatoResponse {
    private UUID id;
    private String email;
    private String telefone;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String fax;
}
