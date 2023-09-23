package br.com.digitalhouse.produto.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Contato")
public class Contato {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
@Column(length = 80, nullable = false)
    private String email;
@Column(length = 80, nullable = false)
    private String telefone;
@Column(length = 80, nullable = false)
    private LocalDate created_at;
@Column(length = 80, nullable = false)
    private LocalDate updated_at;
@Column(length = 80, nullable = false)
    private String fax;
}
