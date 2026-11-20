package com.casamento.casamento_webservice.dto.response;

import java.util.List;

public record GrupoConviteResponse(
        Integer id,
        String nomeExibicao,
        List<ConvidadoResponse> convidados
) {
}
