package com.example.javamasterproject.mappers;

import com.example.javamasterproject.dto.MessageDTO;
import com.example.javamasterproject.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageMapper MAPPER = Mappers.getMapper(MessageMapper.class);

    MessageDTO mapToMessageDTO(Message message);

    Message mapToMessage(MessageDTO messageDTO);
}