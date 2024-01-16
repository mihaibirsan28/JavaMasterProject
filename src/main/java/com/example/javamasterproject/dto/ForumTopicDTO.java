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
public class ForumTopicDTO {
    private String id;
    private String userId;

    private LocalDateTime createdAt;
    private String title;
    private String carId;

    private String type;

    private Integer numberOfComments;
}
