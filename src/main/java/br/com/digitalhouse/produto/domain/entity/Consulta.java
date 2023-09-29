package br.com.digitalhouse.produto.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    //    private UUID id_paciente;
//    private UUID dentista_id;
////    private UUID id_clinica;
//    private UUID id_consultas;
    @Column(nullable = false, length = 80)
    private LocalDate dataConsulta;
    private Instant created_at;
    private Instant updated_at;
    @Column(nullable = false, length = 80)
    private String descricao;
    private Boolean cancelada;
    @Column(nullable = false, length = 80)
    private String motivoCancelamento;
//    private Paciente paciente;
//    private Dentista dentista;
    @ManyToOne
    @JoinColumn(name = "id_clinica")
    private Clinica clinica;
// Add getters and setters

}