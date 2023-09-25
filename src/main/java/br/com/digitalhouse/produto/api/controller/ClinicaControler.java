package br.com.digitalhouse.produto.api.controller;

import br.com.digitalhouse.produto.api.dto.request.ClinicaRequest;
import br.com.digitalhouse.produto.api.dto.response.*;
import br.com.digitalhouse.produto.domain.entity.Clinica;
import br.com.digitalhouse.produto.domain.entity.Consulta;
import br.com.digitalhouse.produto.domain.entity.Contato;
import br.com.digitalhouse.produto.domain.entity.Endereco;
import br.com.digitalhouse.produto.domain.service.impl.ClinicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("v1/clinica")
public class ClinicaControler {
    private ClinicaServiceImpl clinicaServiceImpl;

    @Autowired
    public ClinicaControler(ClinicaServiceImpl clinicaServiceImpl){
        this.clinicaServiceImpl = clinicaServiceImpl;
    }

    @GetMapping()
    ResponseEntity<ClinicaWrapperResponse> getAllClinicas(){
        List<Clinica>clinicas =  clinicaServiceImpl.readAllClinicas();
        ClinicaWrapperResponse clinicaWrapperResponse = new ClinicaWrapperResponse();
        Endereco enderecoResponse = new Endereco("sla", "sla", "sla","sla","21");
        clinicaWrapperResponse.setClinicas(clinicas.stream().map(clinica -> {
            ClinicaListResponse clinicaListResponse = new ClinicaListResponse();
            clinicaListResponse.setId(clinica.getId());
            clinicaListResponse.setNome(clinica.getNome());
            clinicaListResponse.setCnpj(clinica.getCnpj());
            clinicaListResponse.setRazao_social(clinica.getRazao_social());
//            enderecoResponse.setCidade(request.getEnderecoRequest()().getCidade());
//            clinicaListResponse.setEndereco(enderecoResponse);
//            clinicaListResponse.set(clinica.getRazao_social());
            clinicaListResponse.setEndereco(enderecoResponse);
            clinicaListResponse.setContato(clinica.getContato());
            clinicaListResponse.setDescricao(clinica.getDescricao());
//            clinicaListResponse.setCreated_at(clinica.getCreated_at());
//            clinicaListResponse.setUpdated_at(clinica.getUpdated_at());
            return clinicaListResponse;
        }).toList());
        return ResponseEntity.ok(clinicaWrapperResponse);
    }
    @PostMapping()
    ResponseEntity<?> clinicas(@RequestBody @Valid ClinicaRequest request) {
        Clinica clinica = new Clinica();
        clinica.setNome(request.getNome());
        clinica.setCnpj(request.getCnpj());
        clinica.setRazao_social(request.getRazao_social());
//        clinica.setCreated_at(request.getCreated_at());
//        clinica.setUpdated_at(request.getUpdated_at());
        clinica.setDescricao(request.getDescricao());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(request.getEnderecoRequest().getLogradouro());
        endereco.setBairro(request.getEnderecoRequest().getBairro());
//        endereco.setCreated_at(request.getEnderecoRequest().getCreated_at());
//        endereco.setUpdated_at(request.getEnderecoRequest().getUpdated_at());
        endereco.setCidade(request.getEnderecoRequest().getCidade());
        endereco.setEstado(request.getEnderecoRequest().getEstado());
        endereco.setCep(request.getEnderecoRequest().getCep());

        Contato contato = new Contato();
        contato.setEmail(request.getContatoRequest().getEmail());
        contato.setTelefone(request.getContatoRequest().getTelefone());
        contato.setFax(request.getContatoRequest().getFax());

        clinica.setEndereco(endereco);
        clinica.setContato(contato);

        Clinica clinicaCriada = clinicaServiceImpl.createClinica(clinica);
        return ResponseEntity.ok(clinicaCriada.getId());
    }
//        List<Empresa> empresas = empresaService.buscarEmpresas(termo);
//    EmpresaWrapperResponse empresaWrapperResponse = new EmpresaWrapperResponse();
//        empresaWrapperResponse.setEmpresas(empresas.stream().map(empresa -> {
//        EmpresaListResponse empresaListResponse = new EmpresaListResponse();
//        empresaListResponse.setId(empresa.getId());
//        empresaListResponse.setNome(empresa.getNome());
//        empresaListResponse.setCnpj(empresa.getCnpj());
//        return empresaListResponse;
//    }).toList());
//        return ResponseEntity.ok(empresaWrapperResponse);
//}
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
