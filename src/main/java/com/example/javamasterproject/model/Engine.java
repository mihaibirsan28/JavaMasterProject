package com.example.javamasterproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity(name = "Engine")
@Table(name = "engines" ,uniqueConstraints = {@UniqueConstraint(columnNames = {"code"})})
public class Engine extends CarComponent {

    @Column(name = "size", nullable = false)
    private Integer size;

    @Column(name = "fuel", nullable = false)
    private String fuel;

    @Column(name = "number_of_cylindres", nullable = false)
    private Integer numberOfCylindres;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "photo", nullable = false)
    private String photo;
}
