package br.com.digitalhouse.produto.api.controller;

import br.com.digitalhouse.produto.api.dto.response.ClinicaListResponse;
import br.com.digitalhouse.produto.api.dto.response.ClinicaResponse;
import br.com.digitalhouse.produto.api.dto.response.ClinicaWrapperResponse;
import br.com.digitalhouse.produto.domain.entity.Clinica;
import br.com.digitalhouse.produto.domain.service.ClinicaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/clinica")
public class ClinicaControler {
    private ClinicaService clinicaService;

    @Autowired
    public ClinicaControler(ClinicaService clinicaService){
        this.clinicaService = clinicaService;
    }

    @GetMapping
    ResponseEntity<ClinicaWrapperResponse> getAllClinicas(){
        List<Clinica>clinicas =  clinicaService.readAllClinicas();
        ClinicaWrapperResponse clinicaWrapperResponse = new ClinicaWrapperResponse();
        clinicaWrapperResponse.setClinicas(clinicas.stream().map(clinica -> {
            ClinicaListResponse clinicaListResponse = new ClinicaListResponse();
            clinicaListResponse.setId(clinica.getId());
            clinicaListResponse.setNome(clinica.getNome());
            clinicaListResponse.setCnpj(clinica.getCnpj());
            return clinicaListResponse;
        }).toList());
        return ResponseEntity.ok(clinicaWrapperResponse);
    }
    @PostMapping
            ResponseEntity<>
        List<Empresa> empresas = empresaService.buscarEmpresas(termo);
    EmpresaWrapperResponse empresaWrapperResponse = new EmpresaWrapperResponse();
        empresaWrapperResponse.setEmpresas(empresas.stream().map(empresa -> {
        EmpresaListResponse empresaListResponse = new EmpresaListResponse();
        empresaListResponse.setId(empresa.getId());
        empresaListResponse.setNome(empresa.getNome());
        empresaListResponse.setCnpj(empresa.getCnpj());
        return empresaListResponse;
    }).toList());
        return ResponseEntity.ok(empresaWrapperResponse);
}
}
