package com.example.javamasterproject.repository;

import com.example.javamasterproject.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {



    Page<Car> findAll(Pageable pageable);

    List<Car> findAllByBrandAndModel(String brand, String model);

    List<Car> findAllByBrand(String brand);


}
