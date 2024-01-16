package com.example.javamasterproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class CarComponent extends BaseEntity{

    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "photos", nullable = false)
    private String photos;

    @Column(name = "compatibility", nullable = false)
    private String compatibility;

    @Column(name = "condition")
    private String condition;

    @Column(name = "mileage", nullable = false)
    private Integer mileage;
}
