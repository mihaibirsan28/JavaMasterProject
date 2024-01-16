package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.CarDTO;
import com.example.javamasterproject.mappers.CarMapper;
import com.example.javamasterproject.model.Car;
import com.example.javamasterproject.repository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class CarService {

    private final CarMapper carMapper;

    private final CarRepository carRepository;

    public String createCar(CarDTO carDTO) {
        Car car = carMapper.mapToCar(carDTO);
        carRepository.save(car);
        return car.getId();
    }

    public CarDTO getCarById(String id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        CarDTO carDTO = carMapper.mapToCarDTO(car);
        return carDTO;
    }

    public List<CarDTO> getAllCars() {
        List<Car> carEntities = carRepository.findAll();
        List<CarDTO> cars = new ArrayList<>();
        for (Car car : carEntities) {
            cars.add(carMapper.mapToCarDTO(car));
        }
        return cars;
    }

//    public List<CarDTO> getAllCarsByBrand(String brand) {
//        List<Car> carEntities = carRepository.findAllByBrand(brand);
//        List<CarDTO> cars = new ArrayList<>();
//        for (Car car: carEntities) {
//            cars.add(carMapper.mapToCarDTO(car));
//        }
//        return cars;
//    }
//
//    public List<CarDTO> getAllCarsByBrandAndModel(String brand, String model) {
//        List<Car> carEntities = carRepository.findAllByBrandAndModel(brand, model);
//        List<CarDTO> cars = new ArrayList<>();
//        for (Car car: carEntities) {
//            cars.add(carMapper.mapToCarDTO(car));
//        }
//        return cars;
//    }

    public Car updateCar(String id, CarDTO carDTO ) {
        Car car = carMapper.mapToCar(carDTO);
        carRepository.save(car);
        return car;
//        Optional<Car> carOptional = carRepository.findById(id);

//        if (carOptional.isPresent()) {
//
//            Car existingCar = carOptional.get();
//            existingCar.setBrand(carDTO.getBrand());
//            existingCar.setModel(carDTO.getModel());
//            existingCar.setVersion(carDTO.getVersion());
//            existingCar.setProductionStart(carDTO.getProductionStart());
//            existingCar.setProductionEnd(carDTO.getProductionEnd());
//            CarDTO car = carMapper.mapToCarDTO(existingCar);
//            return carRepository.save(existingCar);
//        }
//        else {
//            throw new RuntimeException("Car not found");
//        }
    }

    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }
}
