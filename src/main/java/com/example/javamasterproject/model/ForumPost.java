package com.example.javamasterproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "ForumPost")
@Table(name = "forum_posts")
public class ForumPost extends BaseEntity{

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "topic_id", nullable = false)
    private String topicId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "nr_of_coments", nullable = false)
    private Integer nrOfComments;
}
