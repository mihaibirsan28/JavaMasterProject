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
public class ExteriorComponentDTO {
    @NotEmpty
    private String id;
    @NotEmpty
    private String userId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    @Size(min = 0)
    private Integer price;

    private String photos;
    @NotEmpty
    private String compatibility;
    @NotEmpty
    private String condition;
    @NotEmpty
    private Integer mileage;
    @NotEmpty
    private String material;
    @NotEmpty
    private String color;
    @NotEmpty
    private String finish;
    @NotEmpty
    private String placement;

}
