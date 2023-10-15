package br.com.digitalhouse.produto.domain.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;
import java.time.LocalDate;
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
@Table(name = "Dentista")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable=false)
    private String nome;
    @Column(nullable=false)
    private LocalDate data_nascimento;
    @Column(nullable=false)
    private String especialidade;

    private Instant criado_em;

    private Instant atualizado_em;

    private EnumSexo enumSexo;

    private UUID contato_id;
    @ManyToMany(mappedBy = "Dentistas")
    private Set<Clinica> Clinicas;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato")
    private Set<Contato> Contato;
    @OneToOne(mappedBy = "dentista")
    private Consulta consulta;

    public Dentista(String nome, LocalDate data_nascimento, String especialidade) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.especialidade = especialidade;
    }
}