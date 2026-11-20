package com.casamento.casamento_webservice.dto.request;

import com.casamento.casamento_webservice.model.enums.EPresenca;
import org.antlr.v4.runtime.misc.NotNull;

public record ConvidadoPresencaRequest(
        @NotNull
        Integer id,

        @NotNull
        EPresenca presenca
) {
}