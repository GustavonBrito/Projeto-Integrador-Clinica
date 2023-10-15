package br.com.digitalhouse.produto.domain.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;
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
@Table(name = "Consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 80)
    private LocalDate dataConsulta;
    private Instant created_at;
    private Instant updated_at;
    @Column(nullable = false, length = 80)
    private String descricao;
    private Boolean cancelada;
    @Column(nullable = false, length = 80)
    private String motivoCancelamento;
    @ManyToOne
    @JoinColumn(name = "id_clinica")
    private Clinica clinica;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dentista", referencedColumnName= "id")
    private Dentista dentista;

}