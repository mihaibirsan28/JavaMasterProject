package com.example.javamasterproject.repository;

import com.example.javamasterproject.model.Engine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineRepository extends JpaRepository<Engine, String> {



    List<Engine> findAllByName(String name);

    Page<Engine> findAll(Pageable pageable);

    List<Engine> findAllByUserId(String id);

    List<Engine> findAllByCode(String code);



}
