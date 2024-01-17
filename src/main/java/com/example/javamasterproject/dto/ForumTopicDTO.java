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
public class ForumTopicDTO {
    @NotEmpty
    private String id;
    @NotEmpty
    private String userId;
    @NotEmpty
    private LocalDateTime createdAt;
    @NotEmpty
    private String title;
    @NotEmpty
    private String carId;
    @NotEmpty
    private String type;
    @NotEmpty
    private Integer numberOfComments;
}
