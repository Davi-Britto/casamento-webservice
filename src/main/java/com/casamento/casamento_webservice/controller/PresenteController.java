package com.casamento.casamento_webservice.controller;

import com.casamento.casamento_webservice.dto.request.AlterarPresentesRecebidosRequest;
import com.casamento.casamento_webservice.dto.response.PresenteResponse;
import com.casamento.casamento_webservice.mapper.PresenteMapper;
import com.casamento.casamento_webservice.service.PresenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presentes")
@RequiredArgsConstructor
public class PresenteController {

    private final PresenteService service;
    private final PresenteMapper mapper;

    @GetMapping
    public ResponseEntity<List<PresenteResponse>> listarPresentes() {

        List<PresenteResponse> response =
                mapper.toResponse(service.listarPresentes());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/recebidos")
    public ResponseEntity<Void> alterarRecebidos(
            @Valid @RequestBody AlterarPresentesRecebidosRequest request) {

        service.alterarRecebidos(request);

        return ResponseEntity.noContent().build();
    }
}