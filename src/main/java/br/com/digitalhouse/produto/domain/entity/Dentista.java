package br.com.digitalhouse.produto.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "Dentista")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable=false)
    private String nome;
    @Column(nullable=false)
    private LocalDate data_nascimento;
    @Column(nullable=false)
    private String especialidade;
    @Column(nullable=false)
    private Instant criado_em;
    @Column(nullable = false)
    private Instant atualizado_em;
    @Column(nullable=false)
    private EnumSexo enumSexo;
    @Column(nullable=false)
    private UUID contato_id;
    @ManyToMany(mappedBy = "Dentistas")
    private Set<Clinica> clinicas;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Set<Consulta> consultas;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Set<Contato> contato;
}