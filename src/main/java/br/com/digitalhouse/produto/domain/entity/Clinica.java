                package br.com.digitalhouse.produto.domain.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;


@Setter
@Getter
@Entity
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "Clinica")
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(length = 20, nullable = false)
    private String cnpj;
    @Column(nullable = false)
    @Size(min = 5)
    private String razao_social;

    private Instant created_at;

    private Instant updated_at;
    @Column(nullable = false)
    private String descricao;

    @ManyToMany
    @JoinTable(
        name = "clinica_dentista",
        joinColumns = @JoinColumn(name= "id_clinica"),
        inverseJoinColumns = @JoinColumn(name = "id_dentista")
    )
    private Set<Dentista> Dentistas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_clinica")
    private Set<Consulta> Consultas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_clinica")
    private Set<Contato> Contatos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato", referencedColumnName= "id")
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName= "id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_consulta", referencedColumnName= "id")
    private Consulta consulta;
}
