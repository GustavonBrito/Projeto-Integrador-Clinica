package br.com.digitalhouse.produto.domain.repository;

import br.com.digitalhouse.produto.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRespository extends JpaRepository<Paciente, UUID> {
}
