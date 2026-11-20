package com.casamento.casamento_webservice.mapper;

import com.casamento.casamento_webservice.dto.response.GrupoConviteResponse;
import com.casamento.casamento_webservice.model.GrupoConvite;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = ConvidadoMapper.class
)
public interface GrupoConviteMapper {

    GrupoConviteResponse toResponse(GrupoConvite grupoConvite);
}