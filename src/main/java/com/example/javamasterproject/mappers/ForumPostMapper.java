package com.example.javamasterproject.mappers;

import com.example.javamasterproject.dto.ForumPostDTO;
import com.example.javamasterproject.model.ForumPost;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ForumPostMapper {
    ForumPostMapper MAPPER = Mappers.getMapper(ForumPostMapper.class);

    ForumPostDTO mapToForumPostDTO(ForumPost forumPost);

    ForumPost mapToForumPost(ForumPostDTO forumPostDTO);
}
