package com.example.javamasterproject.mappers;

import com.example.javamasterproject.dto.ExteriorComponentDTO;
import com.example.javamasterproject.model.ExteriorComponent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExteriorComponentMapper {
    ExteriorComponentMapper MAPPER = Mappers.getMapper(ExteriorComponentMapper.class);

    ExteriorComponentDTO mapToExteriorComponentDTO(ExteriorComponent exteriorComponent);

    ExteriorComponent mapToExteriorComponent(ExteriorComponentDTO exteriorComponentDTO);
}
