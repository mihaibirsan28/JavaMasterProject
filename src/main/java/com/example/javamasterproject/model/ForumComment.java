package com.example.javamasterproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity(name = "ForumComment")
@Table(name = "forum_comments")
public class ForumComment extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "post_id", nullable = false)
    private String postId;

    @Column(name = "content", nullable = false)
    private String content;
}
