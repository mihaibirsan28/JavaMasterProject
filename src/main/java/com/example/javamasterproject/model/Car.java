package com.example.javamasterproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "car")
@Table(name = "cars")
public class Car extends BaseEntity{
    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "production_start", nullable = false)
    private Integer productionStart;

    @Column(name = "production_end", nullable = false)
    private Integer productionEnd;
}
