package com.casamento.casamento_webservice.mapper;

import com.casamento.casamento_webservice.dto.response.PresenteResponse;
import com.casamento.casamento_webservice.model.Presente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PresenteMapper {

    PresenteResponse toResponse(Presente presente);

    List<PresenteResponse> toResponse(List<Presente> presentes);
}