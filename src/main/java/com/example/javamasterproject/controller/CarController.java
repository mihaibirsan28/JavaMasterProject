package com.example.javamasterproject.controller;

import com.example.javamasterproject.dto.CarDTO;
import com.example.javamasterproject.model.Car;
import com.example.javamasterproject.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private  CarService carService;


    @PostMapping("")
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO car) {
        String createdCar = carService.createCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.getCarById(createdCar));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable String id) {
        CarDTO car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

//    @GetMapping("/all/{brand}")
//    public ResponseEntity<List<CarDTO>> getAllCarsByBrand(@PathVariable String brand) {
//        List<CarDTO> cars = carService.getAllCarsByBrand(brand);
//        return ResponseEntity.ok(cars);
//    }
//
//    @GetMapping("all/{brand}/{model}")
//    public ResponseEntity<List<CarDTO>> getAllCarsByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
//        List<CarDTO> cars = carService.getAllCarsByBrandAndModel(brand, model);
//        return ResponseEntity.ok(cars);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable String id, @RequestBody CarDTO carDTO) {
        carDTO.setId(id);
        Car updatedCar = carService.updateCar(id, carDTO);
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable String id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
