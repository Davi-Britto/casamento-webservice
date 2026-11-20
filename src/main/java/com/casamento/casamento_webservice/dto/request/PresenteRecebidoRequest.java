package com.casamento.casamento_webservice.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PresenteRecebidoRequest(

        @NotNull
        @Positive
        Integer id,

        @NotNull
        Boolean recebido

) {
}