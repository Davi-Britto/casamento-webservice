package com.casamento.casamento_webservice.dto.response;

public record PresenteResponse(
        Integer id,
        String nome,
        String categoria,
        Boolean recebido,
        Integer ordem
) {
}