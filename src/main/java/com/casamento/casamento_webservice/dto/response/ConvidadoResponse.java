package com.casamento.casamento_webservice.dto.response;

import com.casamento.casamento_webservice.model.enums.EPresenca;

import java.time.LocalDateTime;

public record ConvidadoResponse(
        Integer id,
        String nome,
        EPresenca presenca,
        LocalDateTime dataConfirmacao
) {
}
