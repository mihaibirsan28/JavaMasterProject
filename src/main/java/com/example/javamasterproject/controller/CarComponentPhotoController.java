//package com.example.javamasterproject.controller;
//
//import com.example.javamasterproject.dto.CarComponentPhotoDTO;
//import com.example.javamasterproject.service.CarComponentPhotoService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/api/photos")
//public class CarComponentPhotoController {
//
//    @Autowired
//    private CarComponentPhotoService carComponentPhotoService;
//
//    @PostMapping("")
//    public ResponseEntity<CarComponentPhotoDTO> createCarComponentPhoto(@RequestBody CarComponentPhotoDTO carComponentPhotoDTO) {
//        String createdPhoto = carComponentPhotoService.createCarComponentPhoto(carComponentPhotoDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(carComponentPhotoService.getCarComponentPhotoById(createdPhoto));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CarComponentPhotoDTO> getCarComponentPhotoById(@PathVariable String id) {
//        CarComponentPhotoDTO photo = carComponentPhotoService.getCarComponentPhotoById(id);
//        return ResponseEntity.ok(photo);
//    }
//
//    @GetMapping("/all/{carComponent_id}")
//    public ResponseEntity<List<CarComponentPhotoDTO>> getAllCarComponentPhotoByCarComponentId(@PathVariable String carComponent_id) {
//        List<CarComponentPhotoDTO> photos = carComponentPhotoService.getAllCarComponetPhotosByCarComponentId(carComponent_id);
//        return ResponseEntity.ok(photos);
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<CarComponentPhotoDTO>> getAllCarComponentPhoto() {
//        List<CarComponentPhotoDTO> photos = carComponentPhotoService.getAllCarComponetPhotos();
//        return ResponseEntity.ok(photos);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCarComponentPhoto(@PathVariable String id) {
//        carComponentPhotoService.deleteCarComponentPhoto(id);
//        return ResponseEntity.noContent().build();
//    }
//}
