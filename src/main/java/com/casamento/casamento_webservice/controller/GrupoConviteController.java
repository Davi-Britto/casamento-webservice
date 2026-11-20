package com.casamento.casamento_webservice.controller;

import com.casamento.casamento_webservice.dto.request.AlterarPresencasRequest;
import com.casamento.casamento_webservice.dto.response.GrupoConviteResponse;
import com.casamento.casamento_webservice.mapper.GrupoConviteMapper;
import com.casamento.casamento_webservice.model.GrupoConvite;
import com.casamento.casamento_webservice.service.GrupoConviteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convites")
@RequiredArgsConstructor
public class GrupoConviteController {

    private final GrupoConviteService service;
    private final GrupoConviteMapper mapper;

    @GetMapping("/{token}")
    public ResponseEntity<GrupoConviteResponse> buscarPorToken(@PathVariable String token) {
        GrupoConvite entity = service.findByToken(token);

        if (entity == null) {
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(mapper.toResponse(entity));
    }

    @PutMapping("/{token}/presencas")
    public ResponseEntity<Void> alterarPresencas(@PathVariable String token, @Valid @RequestBody AlterarPresencasRequest request) {
        service.alterarPresencas(token, request);
        return ResponseEntity.noContent().build();
    }
}
