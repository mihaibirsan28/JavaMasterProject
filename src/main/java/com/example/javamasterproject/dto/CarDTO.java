package com.example.javamasterproject.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class CarDTO {
    private String id;

    private String brand;

    private String model;

    private String version;

    private Integer productionStart;

    private Integer productionEnd;
}
