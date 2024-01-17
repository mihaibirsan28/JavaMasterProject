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
public class GearboxDTO {
    @NotEmpty
    private String id;
    @NotEmpty
    private String userId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private Integer price;
    private String photos;
    @NotEmpty
    private String compatibility;
    @NotEmpty
    private String condition;
    @NotEmpty
    private Integer mileage;
    @NotEmpty
    private Integer gears;
    @NotEmpty
    private String type;
    @NotEmpty
    private String transmission;

}
