package com.example.javamasterproject.mappers;

import com.example.javamasterproject.dto.UserDTO;
import com.example.javamasterproject.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserDTO mapToUserDTO(User user);

    User mapToUser(UserDTO userDTO);
}
