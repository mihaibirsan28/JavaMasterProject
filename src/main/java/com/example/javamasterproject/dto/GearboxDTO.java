package com.example.javamasterproject.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class GearboxDTO {
    private String id;

    private String userId;

    private String name;
    private String description;
    private Integer price;

    private String photos;
    private String compatibility;
    private String condition;
    private Integer mileage;
    private Integer gears;
    private String type;
    private String transmission;

}
