package com.casamento.casamento_webservice.mapper;

import com.casamento.casamento_webservice.dto.response.ConvidadoResponse;
import com.casamento.casamento_webservice.model.Convidado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConvidadoMapper {

    ConvidadoResponse toResponse(Convidado convidado);
}