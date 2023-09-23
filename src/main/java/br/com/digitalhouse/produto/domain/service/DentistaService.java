package br.com.digitalhouse.produto.domain.service;

import br.com.digitalhouse.produto.domain.entity.Dentista;
import br.com.digitalhouse.produto.domain.repository.DentistaRepository;
import br.com.digitalhouse.produto.domain.service.impl.DentistaServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DentistaService implements DentistaServiceImpl {

    DentistaRepository dentistaRepository;
    public DentistaService (DentistaRepository dentistaRepository){
        this.dentistaRepository = dentistaRepository;
    }
    @Override
    public Dentista createDentista(Dentista dentista) {
        return this.dentistaRepository.save(dentista);
    }

    @Override
    public Dentista updateDentista(Dentista dentista) {
        return this.dentistaRepository.save(dentista);
    }

    @Override
    public Dentista readDentista(UUID id) {
        return this.dentistaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Dentista> readDentistas() {
        return this.dentistaRepository.findAll();
    }

    @Override
    public void deleteDentista(UUID id) {
        this.dentistaRepository.deleteById(id);
    }
}
