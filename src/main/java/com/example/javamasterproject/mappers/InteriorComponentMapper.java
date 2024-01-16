package com.example.javamasterproject.mappers;

import com.example.javamasterproject.dto.InteriorComponentDTO;
import com.example.javamasterproject.model.InteriorComponent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InteriorComponentMapper {
    InteriorComponentMapper MAPPER = Mappers.getMapper(InteriorComponentMapper.class);

    InteriorComponentDTO mapToInteriorComponentDTO(InteriorComponent interiorComponent);

    InteriorComponent mapToInteriorComponent(InteriorComponentDTO interiorComponentDTO);
}
