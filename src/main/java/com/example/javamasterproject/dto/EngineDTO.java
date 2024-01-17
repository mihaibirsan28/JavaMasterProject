package com.example.javamasterproject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class EngineDTO {
    @NotEmpty
    private String id;
    @NotEmpty
    private String userId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    @Size(min = 1)
    private Integer price;

    private String photos;
    @NotEmpty
    private String compatibility;
    @NotEmpty
    private String condition;
    @NotEmpty
    private Integer mileage;
    @NotEmpty
    @Size(min = 500, max = 9000)
    private Integer size;
    @NotEmpty
    private String fuel;
    @NotEmpty
    private Integer numberOfCylindres;
    @NotEmpty
    private String code;
    @NotEmpty
    private String photo;

}
