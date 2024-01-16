package com.example.javamasterproject.repository;


import com.example.javamasterproject.model.Gearbox;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GearboxRepository extends JpaRepository<Gearbox, String> {



    @Override
    Page<Gearbox> findAll(Pageable pageable);

    List<Gearbox> findAllByName(String name);

    List<Gearbox> findAllByUserId(String id);


    List<Gearbox> findAllByTransmission(String transmission);



}
