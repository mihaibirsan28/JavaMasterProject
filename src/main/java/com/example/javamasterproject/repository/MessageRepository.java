package com.example.javamasterproject.repository;

import com.example.javamasterproject.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, String> {

    @Override
    Page<Message> findAll(Pageable pageable);

}