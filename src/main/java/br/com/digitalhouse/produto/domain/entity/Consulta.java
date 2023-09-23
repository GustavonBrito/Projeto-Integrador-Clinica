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
    private UUID paciente_id;
    private UUID dentista_id;
    private UUID clinica_id;
    @Column(nullable = false, length = 80)
    private Date dataConsulta;
    private Date created_at;
    private Date updated_at;
    @Column(nullable = false, length = 80)
    private String descricao;
    private Boolean cancelada;
    @Column(nullable = false, length = 80)
    private String motivoCancelamento;

// Add getters and setters

}
