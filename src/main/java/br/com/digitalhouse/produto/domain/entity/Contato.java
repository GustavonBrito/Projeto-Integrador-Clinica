package br.com.digitalhouse.produto.domain.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Table(name = "Contato")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(length = 80, nullable = false)
    private String email;
    @Column(length = 80, nullable = false)
    private String telefone;

    private LocalDate created_at;

    private LocalDate updated_at;
    @Column(length = 80, nullable = false)
    private String fax;
    @OneToOne(mappedBy = "contato")
    private Clinica clinica;

    public Contato(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }
}
