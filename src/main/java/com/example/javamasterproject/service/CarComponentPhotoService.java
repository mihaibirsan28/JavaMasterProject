//package com.example.javamasterproject.service;
//
//import com.example.javamasterproject.dto.CarComponentPhotoDTO;
//import com.example.javamasterproject.mappers.CarComponentPhotoMapper;
//import com.example.javamasterproject.model.CarComponentPhoto;
//import com.example.javamasterproject.repository.CarComponentPhotoRepository;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class CarComponentPhotoService {
//
//    private final CarComponentPhotoMapper carComponentPhotoMapper;
//
//    private final CarComponentPhotoRepository carComponentPhotoRepository;
//
//    public String createCarComponentPhoto(CarComponentPhotoDTO carComponentPhotoDTO) {
//        CarComponentPhoto photo = carComponentPhotoMapper.mapToCarComponentPhoto(carComponentPhotoDTO);
//        carComponentPhotoRepository.save(photo);
//        return photo.getPhotoId();
//    }
//
//    public CarComponentPhotoDTO getCarComponentPhotoById(String id) {
//        CarComponentPhoto carComponentPhoto = carComponentPhotoRepository.findById(id).orElseThrow(() -> new RuntimeException("Photo not found"));
//        CarComponentPhotoDTO carComponentPhotoDTO = carComponentPhotoMapper.mapToCarComponentPhotoDTO(carComponentPhoto);
//        return carComponentPhotoDTO;
//    }
//
//    public List<CarComponentPhotoDTO> getAllCarComponetPhotos() {
//        List<CarComponentPhoto> carComponentPhotosEntities = carComponentPhotoRepository.findAll();
//        List<CarComponentPhotoDTO> photos = new ArrayList<>();
//        for (CarComponentPhoto carComponentPhoto : carComponentPhotosEntities) {
//            photos.add(carComponentPhotoMapper.mapToCarComponentPhotoDTO(carComponentPhoto));
//        }
//        return photos;
//    }
//
//    public List<CarComponentPhotoDTO> getAllCarComponetPhotosByCarComponentId(String carComponentId) {
//        List<CarComponentPhoto> carComponentPhotoList = carComponentPhotoRepository.findAllByCarComponentId(carComponentId);
//        List<CarComponentPhotoDTO> photos = new ArrayList<>();
//        for (CarComponentPhoto carComponentPhoto : carComponentPhotoList) {
//            photos.add(carComponentPhotoMapper.mapToCarComponentPhotoDTO(carComponentPhoto));
//        }
//        return photos;
//    }
//
//    public void deleteCarComponentPhoto(String id) {
//        carComponentPhotoRepository.deleteById(id);
//    }
//
//}
