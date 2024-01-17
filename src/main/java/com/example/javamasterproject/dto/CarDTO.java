package com.example.javamasterproject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class CarDTO {
    @NotEmpty
    private String id;
    @NotEmpty
    private String brand;
    @NotEmpty
    private String model;
    @NotEmpty
    private String version;
    @NotEmpty
    private Integer productionStart;
    @NotEmpty
    private Integer productionEnd;
}
