package br.com.digitalhouse.produto.api.controller;

import br.com.digitalhouse.produto.api.dto.request.ConsultaRequest;
import br.com.digitalhouse.produto.api.dto.response.ConsultaListResponse;
import br.com.digitalhouse.produto.api.dto.response.ConsultaWrapperResponse;
import br.com.digitalhouse.produto.domain.entity.Consulta;
import br.com.digitalhouse.produto.domain.entity.Dentista;
import br.com.digitalhouse.produto.domain.entity.Paciente;
import br.com.digitalhouse.produto.domain.service.impl.ConsultaServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/consulta")
public class ConsultaController {
    private ConsultaServiceImpl consultaServiceImpl;
    private Paciente paciente;
    private Dentista dentista;

    @Autowired
    public ConsultaController(ConsultaServiceImpl consultaServiceImpl) {
        this.consultaServiceImpl = consultaServiceImpl;
    }

    @GetMapping()
    ResponseEntity<ConsultaWrapperResponse> getAllConsultas(){
        List<Consulta>consultas = consultaServiceImpl.readAllConsultas();
//        ConsultaRequest consultaRequest = new ConsultaRequest();
        ConsultaWrapperResponse consultaWrapperResponse = new ConsultaWrapperResponse();
            consultaWrapperResponse.setConsultaListResponse(consultas.stream().map(consulta -> {
            ConsultaListResponse consultaListResponse = new ConsultaListResponse();
            consultaListResponse.setId(consulta.getId());
            consultaListResponse.setDataConsulta(consulta.getDataConsulta());
            consultaListResponse.setCreated_at(Instant.now());
            consultaListResponse.setDescricao(consulta.getDescricao());
            consultaListResponse.setCancelada(consulta.getCancelada());
            consultaListResponse.setMotivoCancelamento(consulta.getMotivoCancelamento());
            return consultaListResponse;
        }).toList());
            return ResponseEntity.ok(consultaWrapperResponse);
    }

    @PostMapping()
    ResponseEntity<?>postAllConsultas(@RequestBody @Valid ConsultaRequest consultaRequest){
        Consulta consulta = new Consulta();
        consulta.setDataConsulta(consultaRequest.getDataConsulta());
        consulta.setDescricao(consultaRequest.getDescricao());
        consulta.setCancelada(consultaRequest.getCancelada());
        consulta.setMotivoCancelamento(consultaRequest.getMotivoCancelamento());
        paciente.setNome(consultaRequest.getPaciente().getNome());
        dentista.setNome(consultaRequest.getDentista().getNome());
        consultaRequest.setPaciente(paciente);
        consultaRequest.setDentista(dentista);
        Consulta consultaCriada = consultaServiceImpl.createConsulta(consulta);
        return ResponseEntity.ok(consultaCriada.getId());
    }

    @PutMapping("{id}")
    ResponseEntity<?>putConsulta(@RequestBody @Valid ConsultaRequest consultaRequest, @PathVariable  UUID id){
        Consulta consulta = consultaServiceImpl.readConsulta(id);
        consulta.setDataConsulta(consultaRequest.getDataConsulta());
        consulta.setDescricao(consultaRequest.getDescricao());
        consulta.setCancelada(consultaRequest.getCancelada());
        consulta.setMotivoCancelamento(consultaRequest.getMotivoCancelamento());
        paciente.setNome(consultaRequest.getPaciente().getNome());
        dentista.setNome(consultaRequest.getDentista().getNome());
        consultaRequest.setPaciente(paciente);
        consultaRequest.setDentista(dentista);
        Consulta consultaAtualizada = consultaServiceImpl.updateConsulta(consulta);
        return ResponseEntity.ok(consultaAtualizada);
    }
    @DeleteMapping()
    void deleteConsulta(){

    }
    }

