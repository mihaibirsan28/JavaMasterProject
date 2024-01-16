package com.example.javamasterproject.repository;

import com.example.javamasterproject.model.ForumComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumCommentRepository extends JpaRepository<ForumComment, String> {

    Page<ForumComment> findAll(Pageable pageable);


    List<ForumComment> findAllByPostId(String postId);

    List<ForumComment> findAllByUserId(String userId);



}
