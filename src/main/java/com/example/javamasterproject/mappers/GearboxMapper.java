package com.example.javamasterproject.mappers;

import com.example.javamasterproject.dto.GearboxDTO;
import com.example.javamasterproject.model.Gearbox;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GearboxMapper {
    GearboxMapper MAPPER = Mappers.getMapper(GearboxMapper.class);

    GearboxDTO mapToGearboxDTO(Gearbox gearbox);

    Gearbox mapToGearbox(GearboxDTO gearboxDTO);
}
