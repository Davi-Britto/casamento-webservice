package com.casamento.casamento_webservice.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record AlterarPresencasRequest(
        @NotEmpty
        List<ConvidadoPresencaRequest> convidados
) {
}