package br.com.digitalhouse.produto.api.controller;

import br.com.digitalhouse.produto.api.dto.openapi.PageParamsClinicaResponse;

import br.com.digitalhouse.produto.api.dto.request.ClinicaRequest;
import br.com.digitalhouse.produto.api.dto.response.*;
import br.com.digitalhouse.produto.domain.entity.Clinica;

import br.com.digitalhouse.produto.domain.entity.Contato;
import br.com.digitalhouse.produto.domain.entity.Endereco;
import br.com.digitalhouse.produto.domain.service.impl.ClinicaServiceImpl;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("v1/clinica")
@Tag(name = "Clinica")
public class ClinicaControler {
    private ClinicaServiceImpl clinicaServiceImpl;
    private Endereco enderecoResponse;
    private Contato contatoResponse;

    @Autowired
    public ClinicaControler(ClinicaServiceImpl clinicaServiceImpl){
        this.clinicaServiceImpl = clinicaServiceImpl;
    }

    @GetMapping("{nome}")
    public ResponseEntity<?> buscarPorAtributo(@PathVariable @Valid String nome) {
        Clinica clinica = clinicaServiceImpl.readClinicabyName(nome);
        Clinica clinicaPorNome = new Clinica();
        clinicaPorNome.setNome(clinica.getNome());
        clinicaPorNome.setCnpj(clinica.getCnpj());
        clinicaPorNome.setDescricao(clinica.getDescricao());
        clinicaPorNome.setRazao_social(clinica.getRazao_social());
        return ResponseEntity.ok(clinicaPorNome);
    }

    @ApiResponse(responseCode = "200", description = "A requisição foi realizada com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(description = "Payload de resposta da por todas consultas.",
                    implementation = PageParamsClinicaResponse.class
            )))
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

}
