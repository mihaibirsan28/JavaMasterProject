package com.example.javamasterproject.repository;

import com.example.javamasterproject.model.ExteriorComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExteriorComponentRepository extends JpaRepository<ExteriorComponent, String> {


    List<ExteriorComponent> findAllByName(String name);

    Page<ExteriorComponent> findAll(Pageable pageable);

    List<ExteriorComponent> findAllByUserId(String id);


    List<ExteriorComponent> findAll();
}
