//package br.com.digitalhouse.produto.domain.service;
//
//import br.com.digitalhouse.produto.domain.entity.Contato;
//import br.com.digitalhouse.produto.domain.repository.ContatoRepository;
//import br.com.digitalhouse.produto.domain.service.impl.ContatoServiceImpl;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class ContatoService implements ContatoServiceImpl {
//
//    private ContatoRepository contatoRepository;
//
//    public ContatoService(ContatoRepository contatoRepository) {
//        this.contatoRepository = contatoRepository;
//    }
//
//    @Override
//    public Contato createContato(Contato contato) {
//        return this.contatoRepository.save(contato);
//    }
//
//    @Override
//    public Contato updateContato(Contato contato) {
//        return this.contatoRepository.save(contato);
//    }
//
//    @Override
//    public Contato readContato(UUID id) {
//        return this.contatoRepository.findById(id).orElseThrow();
//    }
//
//    @Override
//    public List<Contato> readContatos() {
//        return this.contatoRepository.findAll();
//    }
//
//    @Override
//    public void deleteContato(UUID id) {
//        this.contatoRepository.deleteById(id);
//    }
//}
