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
@Table(name = "Endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
//    private UUID id_clinica;
    @Column(length = 100, nullable = false)
    private String logradouro;
    @Column(length = 100, nullable = false)
    private String bairro;

    private Instant created_at;

    private Instant updated_at;
    @Column(length = 100, nullable = false)
    private String cidade;
    @Column(length = 100, nullable = false)
    private String estado;
    @Column(length = 10, nullable = false)
    private String cep;
    @OneToOne(mappedBy = "endereco")
    private Paciente paciente;
//    @ManyToOne
//    @JoinColumn(name = "id_clinica")
//    private Clinica clinica;
    @OneToOne(mappedBy = "endereco")
    private Clinica clinica;

    public Endereco(String logradouro, String bairro, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}
