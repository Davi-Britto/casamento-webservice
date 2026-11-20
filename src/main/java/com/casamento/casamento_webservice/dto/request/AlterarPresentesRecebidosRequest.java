package com.casamento.casamento_webservice.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record AlterarPresentesRecebidosRequest(

        @NotEmpty
        List<@Valid PresenteRecebidoRequest> presentes

) {
}