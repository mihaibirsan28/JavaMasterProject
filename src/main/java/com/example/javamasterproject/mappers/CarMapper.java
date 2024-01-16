package com.example.javamasterproject.mappers;

import com.example.javamasterproject.dto.CarDTO;
import com.example.javamasterproject.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarMapper MAPPER = Mappers.getMapper(CarMapper.class);

    CarDTO mapToCarDTO(Car car);

    Car mapToCar(CarDTO carDTO);
}
