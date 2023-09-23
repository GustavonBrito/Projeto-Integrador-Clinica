                package br.com.digitalhouse.produto.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;


@Setter
@Getter
@Entity
@NoArgsConstructor
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
    private String razao_social;
    @Column(updatable = false)
    private Instant created_at;
    @Column(updatable = false)
    private Instant updated_at;
    @Column(updatable = false)
    private String descricao;
    @Column(updatable = false)
    private UUID endereco_id;
    @Column(updatable = false)
    private UUID contato_id;

    @ManyToMany
    @JoinTable(
        name = "clinica_dentista",
        joinColumns = @JoinColumn(name= "id_clinica"),
        inverseJoinColumns = @JoinColumn(name = "id_dentista")
    )
    private Set<Dentista> Dentistas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinica_id")
    private Set<Consulta> consultas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinica_id")
    private Set<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinica_id")
    private Set<Contato> contatos;
}
