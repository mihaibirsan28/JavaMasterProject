package com.example.javamasterproject.mappers;

import com.example.javamasterproject.dto.ForumCommentDTO;
import com.example.javamasterproject.model.ForumComment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ForumCommentMapper {
    ForumCommentMapper MAPPER = Mappers.getMapper(ForumCommentMapper.class);

    ForumCommentDTO mapToForumCommentDTO(ForumComment forumComment);

    ForumComment mapToForumComment(ForumCommentDTO forumCommentDTO);
}
