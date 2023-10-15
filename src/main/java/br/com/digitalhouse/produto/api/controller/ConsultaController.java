package br.com.digitalhouse.produto.api.controller;

import br.com.digitalhouse.produto.api.dto.openapi.PageParamsConsultaResponse;
import br.com.digitalhouse.produto.api.dto.request.ConsultaRequest;
import br.com.digitalhouse.produto.api.dto.response.ConsultaListResponse;
import br.com.digitalhouse.produto.api.dto.response.ConsultaWrapperResponse;
import br.com.digitalhouse.produto.domain.entity.Consulta;
import br.com.digitalhouse.produto.domain.entity.Dentista;
import br.com.digitalhouse.produto.domain.entity.Paciente;
import br.com.digitalhouse.produto.domain.service.impl.ConsultaServiceImpl;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/consulta")
@Tag(name = "Consulta")
public class ConsultaController {

    private ConsultaServiceImpl consultaServiceImpl;
    private Paciente pacienteRequest;
    private Dentista dentistaRequest;

    @Autowired
    public ConsultaController(ConsultaServiceImpl consultaServiceImpl) {
        this.consultaServiceImpl = consultaServiceImpl;
    }

    @ApiResponse(responseCode = "200", description = "A requisição foi realizada com sucesso",
    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(description = "Payload de resposta da por todas consultas.",
    implementation = PageParamsConsultaResponse.class
    )))
    @GetMapping()
    ResponseEntity<ConsultaWrapperResponse> getAllConsultas(){
        List<Consulta>consultas = consultaServiceImpl.readAllConsultas();
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
        dentistaRequest = new Dentista();
        dentistaRequest.setNome(consultaRequest.getDentista().getNome());
        dentistaRequest.setData_nascimento(consultaRequest.getDentista().getData_nascimento());
        dentistaRequest.setEspecialidade(consultaRequest.getDentista().getEspecialidade());
        dentistaRequest.setEnumSexo(consultaRequest.getDentista().getEnumSexo());
        consulta.setDentista(dentistaRequest);
        Consulta consultaCriada = consultaServiceImpl.createConsulta(consulta);
        return ResponseEntity.ok(consultaCriada.getId());
    }

    @PutMapping("{id}")
    ResponseEntity<?>putConsulta(@RequestBody @Valid ConsultaRequest consultaRequest, @PathVariable  UUID id){
        Consulta consultaById = consultaServiceImpl.readConsulta(id);
        consultaById.setDataConsulta(consultaRequest.getDataConsulta());
        consultaById.setDescricao(consultaRequest.getDescricao());
        consultaById.setCancelada(consultaRequest.getCancelada());
        consultaById.setMotivoCancelamento(consultaRequest.getMotivoCancelamento());
        pacienteRequest.setNome(consultaRequest.getPaciente().getNome());
        dentistaRequest.setNome(consultaRequest.getDentista().getNome());
        Consulta consultaAtualizada = consultaServiceImpl.updateConsulta(consultaById);
        return ResponseEntity.ok(consultaAtualizada);
    }
    @DeleteMapping("{id}")
    @Transactional
    ResponseEntity<?> deleteByIdConsulta(@PathVariable UUID id){
        consultaServiceImpl.deleteConsulta(id);
        return ResponseEntity.ok().build();
    }
    }

