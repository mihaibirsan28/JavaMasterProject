package com.example.javamasterproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "Interior")
@Table(name = "interior_components")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class InteriorComponent extends CarComponent{

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "color", nullable = false)
    private String color;
}
