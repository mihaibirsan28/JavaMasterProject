package com.example.javamasterproject.repository;


import com.example.javamasterproject.model.OtherComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtherComponentRepository extends JpaRepository<OtherComponent, String> {


    @Override
    Page<OtherComponent> findAll(Pageable pageable);

    List<OtherComponent> findAllByUserId(String id);

    List<OtherComponent> findAllByName(String name);

}
