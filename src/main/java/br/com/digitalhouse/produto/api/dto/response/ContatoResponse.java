package br.com.digitalhouse.produto.api.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
public class ContatoResponse {
    private UUID id;
    private String email;
    private String telefone;
    private String fax;

    public ContatoResponse(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }
}
