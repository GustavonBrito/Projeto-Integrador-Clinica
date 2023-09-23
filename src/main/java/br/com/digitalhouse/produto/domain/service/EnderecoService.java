//package br.com.digitalhouse.produto.domain.service;
//
//import br.com.digitalhouse.produto.domain.entity.Endereco;
//import br.com.digitalhouse.produto.domain.repository.EnderecoRepository;
//import br.com.digitalhouse.produto.domain.service.impl.EnderecoServiceImpl;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class EnderecoService implements EnderecoServiceImpl {
//
//    EnderecoRepository enderecoRepository;
//
//    public EnderecoService(EnderecoRepository enderecoRepository){
//        this.enderecoRepository = enderecoRepository;
//    }
//
//    @Override
//    public Endereco createEndereco(Endereco endereco) {
//        return this.enderecoRepository.save(endereco);
//    }
//
//    @Override
//    public Endereco updateEndereco(Endereco endereco) {
//        return this.enderecoRepository;
//    }
//
//    @Override
//    public Endereco readEndereco(UUID id) {
//        return this.enderecoRepository;
//    }
//
//    @Override
//    public List<Endereco> readEnderecos() {
//        return this.enderecoRepository;
//    }
//
//    @Override
//    public void deleteEndereco(UUID id) {
//
//    }
//}
