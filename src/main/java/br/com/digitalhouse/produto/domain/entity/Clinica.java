                package br.com.digitalhouse.produto.domain.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "Clinica")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(length = 20, nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private String razao_social;

    private Instant created_at;

    private Instant updated_at;
    @Column(nullable = false)
    private String descricao;
//    @Column(nullable = false)
//    private UUID endereco_id;
//    @Column(nullable = false)
//    private UUID contato_id;
//    @Column(nullable = false)
//    private Endereco endereco;
//    @Column(nullable = false)
//    private Contato contato;

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

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_clinica")
//    private List<Endereco> Enderecos;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_clinica")
//    private Set<Contato> Contatos;
//    @OneToMany(mappedBy = "clinica")
//    @JsonIgnore
//    private List<Contato> contatos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato", referencedColumnName= "id")
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName= "id")
    private Endereco endereco;
}
