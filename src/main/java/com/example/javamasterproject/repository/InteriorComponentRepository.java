package com.example.javamasterproject.repository;


import com.example.javamasterproject.model.InteriorComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteriorComponentRepository extends JpaRepository<InteriorComponent, String> {


    @Override
    Page<InteriorComponent> findAll(Pageable pageable);

    List<InteriorComponent> findAllByName(String name);

    List<InteriorComponent> findAllByUserId(String id);


    List<InteriorComponent> findAll();
}
