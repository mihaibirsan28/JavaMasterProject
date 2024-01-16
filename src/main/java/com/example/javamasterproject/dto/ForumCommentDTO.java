package com.example.javamasterproject.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class ForumCommentDTO {
    private String id;
    private String userId;
    private String postId;
    private String content;

    private LocalDateTime createdAt;
}
