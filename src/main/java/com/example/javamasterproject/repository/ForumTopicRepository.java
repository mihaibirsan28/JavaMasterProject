package com.example.javamasterproject.repository;

import com.example.javamasterproject.model.ForumTopic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumTopicRepository extends JpaRepository<ForumTopic, String> {

    Page<ForumTopic> findAll(Pageable pageable);

    List<ForumTopic> findAllByTitle(String title);

    List<ForumTopic> findAllByUserId(String userId);

}
