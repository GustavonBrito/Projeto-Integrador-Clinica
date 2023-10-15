package br.com.digitalhouse.produto.domain.repository;

import br.com.digitalhouse.produto.domain.entity.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, UUID> {
    @Query("SELECT m FROM Clinica m  WHERE m.nome = :nome")
    Clinica findByAtributo(@Param("nome") String nome);

}
