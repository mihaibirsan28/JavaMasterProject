package com.example.javamasterproject.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class OtherComponentDTO {
    private String id;
    private String userId;

    private String name;
    private String description;
    private Integer price;

    private String photos;
    private String compatibility;
    private String condition;
    private Integer mileage;
    private String type;

}
