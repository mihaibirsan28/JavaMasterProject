package com.example.javamasterproject.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "Gearbox")
@Table(name = "gearboxes")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Gearbox extends CarComponent{

    @Column(name = "gears", nullable = false)
    private Integer gears;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "transmission", nullable = false)
    private String transmission;


}
