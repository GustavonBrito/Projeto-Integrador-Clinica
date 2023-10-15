package br.com.digitalhouse.produto.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Paciente")
public class Paciente {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private LocalDate data_nascimento;
    @Column(nullable = false)
    private LocalDate criado_em;
    @Column(nullable = false)
    private LocalDate atualizado_em;
    @Column(length = 1)
    private EnumSexo sexo;
    @Column(nullable = false)
    private UUID contato_id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente")
    private Set<Consulta> Consultas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName= "id")
    private Endereco endereco;
}
