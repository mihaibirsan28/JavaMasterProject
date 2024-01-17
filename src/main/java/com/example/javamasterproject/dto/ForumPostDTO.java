package com.example.javamasterproject.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private String id;
    @NotEmpty
    private String userId;
    @NotEmpty
    private String topicId;
    @NotEmpty
    private LocalDateTime createdAt;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private Integer nrOfComments;

}
