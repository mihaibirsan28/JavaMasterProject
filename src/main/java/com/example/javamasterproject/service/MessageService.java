package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.MessageDTO;
import com.example.javamasterproject.mappers.MessageMapper;
import com.example.javamasterproject.model.Message;
import com.example.javamasterproject.repository.MessageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageService {

    private final MessageMapper messageMapper;

    private final MessageRepository messageRepository;

    public String createMessage(MessageDTO messageDTO) {
        Message message = messageMapper.mapToMessage(messageDTO);
        messageRepository.save(message);
        return message.getId();
    }

    public MessageDTO getMessageById(String id) {
        Message message = messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
        MessageDTO messageDTO = messageMapper.mapToMessageDTO(message);
        return messageDTO;
    }

    public List<MessageDTO> getAllMessages() {
        List<Message> messageEntities = messageRepository.findAll();
        List<MessageDTO> messageDTOS = new ArrayList<>();
        for(Message message: messageEntities) {
            messageDTOS.add(messageMapper.mapToMessageDTO(message));
        }
        return messageDTOS;
    }
}