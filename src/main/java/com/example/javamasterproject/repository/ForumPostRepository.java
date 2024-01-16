package com.example.javamasterproject.repository;

import com.example.javamasterproject.model.ForumPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumPostRepository extends JpaRepository<ForumPost, String> {


    Page<ForumPost> findAll(Pageable pageable);


    List<ForumPost> findAllByTitle(String title);

    List<ForumPost> findAllByTopicId(String topicId);

    List<ForumPost> findAllByUserId(String userId);


}
