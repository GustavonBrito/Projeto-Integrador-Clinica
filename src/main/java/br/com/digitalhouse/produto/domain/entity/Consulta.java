package br.com.digitalhouse.produto.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private UUID id_paciente;
    private UUID dentista_id;
//    private UUID id_clinica;
    private UUID id_consultas;
    @Column(nullable = false, length = 80)
    private Date dataConsulta;
    private Date created_at;
    private Date updated_at;
    @Column(nullable = false, length = 80)
    private String descricao;
    private Boolean cancelada;
    @Column(nullable = false, length = 80)
    private String motivoCancelamento;
    @ManyToOne
    @JoinColumn(name = "id_clinica")
    private Clinica clinica;
// Add getters and setters

}
