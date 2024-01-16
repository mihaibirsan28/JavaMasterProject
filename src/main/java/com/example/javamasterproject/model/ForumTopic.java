package com.example.javamasterproject.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity(name = "ForumTopic")
@Table(name = "forum_topics")
public class ForumTopic extends BaseEntity{


    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "car_id", nullable = false)
    private String carId;

    @Column(name = "numberOfComments", nullable = false)
    private Integer numberOfComments;

    @Column(name = "type", nullable = false)
    private String type;

}
