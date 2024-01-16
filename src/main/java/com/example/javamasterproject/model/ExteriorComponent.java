package com.example.javamasterproject.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "exterior")
@Table(name = "exterior_components")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ExteriorComponent extends CarComponent{

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "finish", nullable = false)
    private String finish;

    @Column(name = "placement", nullable = false)
    private String placement;

}
