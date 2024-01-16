package com.example.javamasterproject.mappers;

import com.example.javamasterproject.dto.EngineDTO;
import com.example.javamasterproject.model.Engine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EngineMapper {
    EngineMapper MAPPER = Mappers.getMapper(EngineMapper.class);

    EngineDTO mapToEngineDTO(Engine engine);

    Engine mapToEngine(EngineDTO engineDTO);
}
