package br.com.digitalhouse.produto.domain.service.impl;

import br.com.digitalhouse.produto.domain.entity.Dentista;

import java.util.List;
import java.util.UUID;

public interface DentistaServiceImpl {
    Dentista createDentista(Dentista dentista);
    Dentista updateDentista(Dentista dentista);
    Dentista readDentista(UUID id);
    List<Dentista> readDentistas();
    void deleteDentista(UUID id);
}
