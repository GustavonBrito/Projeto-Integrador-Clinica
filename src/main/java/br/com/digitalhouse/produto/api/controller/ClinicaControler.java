package br.com.digitalhouse.produto.api.controller;

import br.com.digitalhouse.produto.api.dto.request.ClinicaRequest;
import br.com.digitalhouse.produto.api.dto.response.*;
import br.com.digitalhouse.produto.domain.entity.Clinica;
import br.com.digitalhouse.produto.domain.entity.Consulta;
import br.com.digitalhouse.produto.domain.entity.Contato;
import br.com.digitalhouse.produto.domain.entity.Endereco;
import br.com.digitalhouse.produto.domain.service.impl.ClinicaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;


//@Slf4j
@RestController
@RequestMapping("v1/clinica")
public class ClinicaControler {
    private ClinicaServiceImpl clinicaServiceImpl;
    private Endereco enderecoResponse;
    private Contato contatoResponse;
    //private static final Logger logger = (Logger) LoggerFactory.getLogger(ClinicaControler.class);

    @Autowired
    public ClinicaControler(ClinicaServiceImpl clinicaServiceImpl){
        this.clinicaServiceImpl = clinicaServiceImpl;
    }

    @GetMapping()
    ResponseEntity<ClinicaWrapperResponse> getAllClinicas(){
        List<Clinica>clinicas =  clinicaServiceImpl.readAllClinicas();
        ClinicaWrapperResponse clinicaWrapperResponse = new ClinicaWrapperResponse();
        if (this.enderecoResponse == null) {
            return ResponseEntity.noContent().build();
        } else{
            enderecoResponse = new Endereco(enderecoResponse.getLogradouro(), enderecoResponse.getBairro(), enderecoResponse.getCidade(),enderecoResponse.getEstado(),enderecoResponse.getCep());
        }
        if (this.contatoResponse == null) {
            return ResponseEntity.noContent().build();
        } else{
            contatoResponse = new Contato(contatoResponse.getEmail(), contatoResponse.getTelefone());
        }
        clinicaWrapperResponse.setClinicas(clinicas.stream().map(clinica -> {
            ClinicaListResponse clinicaListResponse = new ClinicaListResponse();
            clinicaListResponse.setId(clinica.getId());
            clinicaListResponse.setNome(clinica.getNome());
            clinicaListResponse.setCnpj(clinica.getCnpj());
            clinicaListResponse.setRazao_social(clinica.getRazao_social());
            clinicaListResponse.setDescricao(clinica.getDescricao());
            clinicaListResponse.setUpdated_at(clinica.getUpdated_at());
            clinicaListResponse.setEndereco(enderecoResponse);
            clinicaListResponse.setContato(contatoResponse);
            return clinicaListResponse;
        }).toList());

        return ResponseEntity.ok(clinicaWrapperResponse);
    }
    @PostMapping()
    ResponseEntity<?> createClinica(@RequestBody @Valid ClinicaRequest request) {
        Clinica clinica = new Clinica();
        clinica.setNome(request.getNome());
        clinica.setCnpj(request.getCnpj());
        clinica.setRazao_social(request.getRazao_social());
        clinica.setDescricao(request.getDescricao());
        clinica.setCreated_at(Instant.now());
        clinica.setUpdated_at(null);
        if (request.getRazao_social().length() <= 5){
            ResponseEntity.badRequest().body("Razão Social deve ter um tamanho maior que 5");
        }

        enderecoResponse = new Endereco();
        enderecoResponse.setLogradouro(request.getEnderecoRequest().getLogradouro());
        enderecoResponse.setBairro(request.getEnderecoRequest().getBairro());
        enderecoResponse.setCidade(request.getEnderecoRequest().getCidade());
        enderecoResponse.setEstado(request.getEnderecoRequest().getEstado());
        enderecoResponse.setCep(request.getEnderecoRequest().getCep());
        enderecoResponse.setCreated_at(Instant.now());
        enderecoResponse.setUpdated_at(null);

        contatoResponse = new Contato();
        contatoResponse.setEmail(request.getContatoRequest().getEmail());
        contatoResponse.setTelefone(request.getContatoRequest().getTelefone());
        contatoResponse.setFax(request.getContatoRequest().getFax());

        clinica.setEndereco(enderecoResponse);
        clinica.setContato(contatoResponse);

        Clinica clinicaCriada = clinicaServiceImpl.createClinica(clinica);
        return ResponseEntity.ok(clinicaCriada.getId());
    }
    @PutMapping("{id}")
    ResponseEntity<?> updateClinica(@RequestBody @Valid ClinicaRequest clinicaRequest,@PathVariable UUID id){
       Clinica clinicaId = clinicaServiceImpl.readClinicabyId(id);
       clinicaId.setNome(clinicaRequest.getNome());
       clinicaId.setCnpj(clinicaRequest.getCnpj());
       clinicaId.setRazao_social(clinicaRequest.getRazao_social());
       clinicaId.setDescricao(clinicaRequest.getDescricao());
       clinicaId.setUpdated_at(Instant.now());
       enderecoResponse = new Endereco();
       enderecoResponse.setLogradouro(clinicaRequest.getEnderecoRequest().getLogradouro());
       enderecoResponse.setBairro(clinicaRequest.getEnderecoRequest().getBairro());
       enderecoResponse.setCidade(clinicaRequest.getEnderecoRequest().getCidade());
       enderecoResponse.setEstado(clinicaRequest.getEnderecoRequest().getEstado());
       enderecoResponse.setCep(clinicaRequest.getEnderecoRequest().getCep());
       contatoResponse = new Contato();
       contatoResponse.setEmail(clinicaRequest.getContatoRequest().getEmail());
       contatoResponse.setTelefone(clinicaRequest.getContatoRequest().getTelefone());
       contatoResponse.setFax(clinicaRequest.getContatoRequest().getFax());
       clinicaId.setEndereco(enderecoResponse);
       clinicaId.setContato(contatoResponse);
       Clinica clinicaUpdated = clinicaServiceImpl.updateClinica(clinicaId);
       return ResponseEntity.ok(clinicaUpdated);
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteClinica(@PathVariable UUID id){
        clinicaServiceImpl.deleteClinica(id);
        return ResponseEntity.ok().build();
    }
    // Método abaixo coloca um objeto dentro de um objeto
    private ClinicaListResponse clinicaResponseByClinica (Clinica clinica){
        Endereco endereco = new Endereco();
        endereco.setId(endereco.getId());
        endereco.setLogradouro(endereco.getLogradouro());
        endereco.setBairro(endereco.getBairro());
        endereco.setCreated_at(endereco.getCreated_at());
        endereco.setUpdated_at(endereco.getUpdated_at());
        endereco.setCidade(endereco.getCidade());
        endereco.setEstado(endereco.getEstado());
        endereco.setCep(endereco.getCep());

        Contato contato = new Contato();
        contato.setId(contato.getId());
        contato.setEmail(contato.getEmail());
        contato.setTelefone(contato.getTelefone());
        contato.setCreated_at(contato.getCreated_at());
        contato.setUpdated_at(contato.getUpdated_at());
        contato.setFax(contato.getFax());

        ClinicaListResponse clinicaListResponse = new ClinicaListResponse();
        clinicaListResponse.setEndereco(endereco);
        clinicaListResponse.setContato(contato);
        return clinicaListResponse;

    }
}
