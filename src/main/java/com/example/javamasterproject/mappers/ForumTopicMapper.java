package com.example.javamasterproject.mappers;

import com.example.javamasterproject.dto.ForumTopicDTO;
import com.example.javamasterproject.model.ForumTopic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ForumTopicMapper {
    ForumTopicMapper MAPPER = Mappers.getMapper(ForumTopicMapper.class);

    ForumTopicDTO mapToForumTopicDTO(ForumTopic forumTopic);

    ForumTopic mapToForumTopic(ForumTopicDTO forumTopicDTO);
}
