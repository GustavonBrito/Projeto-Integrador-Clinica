package br.com.digitalhouse.produto.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(length = 100, nullable = false)
    private String logradouro;
    @Column(length = 100, nullable = false)
    private String bairro;
    @Column(length = 100, nullable = false)
    private LocalDate created_at;
    @Column(length = 100, nullable = false)
    private LocalDate updated_at;
    @Column(length = 100, nullable = false)
    private String cidade;
    @Column(length = 100, nullable = false)
    private String estado;
    @Column(length = 10, nullable = false)
    private String cep;


}
