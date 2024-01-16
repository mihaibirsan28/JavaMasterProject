package com.example.javamasterproject.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class MessageDTO {
    private String id;
    private String name;

    private String email;

    private String subject;

    private String message;
}