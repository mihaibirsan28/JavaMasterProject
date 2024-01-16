package com.example.javamasterproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "OtherComponent")
@Table(name = "other_components")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class OtherComponent extends CarComponent{

    @Column(name = "type", nullable = false)
    private String type;

}
