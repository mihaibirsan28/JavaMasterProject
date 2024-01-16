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
public class ForumPostDTO {
    private String id;
    private String userId;
    private String topicId;
    private LocalDateTime createdAt;
    private String title;
    private String content;
    private Integer nrOfComments;

}
