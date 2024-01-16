package com.example.javamasterproject.mappers;

import com.example.javamasterproject.dto.OtherComponentDTO;
import com.example.javamasterproject.model.OtherComponent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OtherComponentMapper {
    OtherComponentMapper MAPPER = Mappers.getMapper(OtherComponentMapper.class);

    OtherComponentDTO mapToOtherComponentDTO(OtherComponent otherComponent);

    OtherComponent mapToOtherComponent(OtherComponentDTO otherComponentDTO);
}
