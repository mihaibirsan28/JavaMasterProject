package com.example.javamasterproject.controller;

import com.example.javamasterproject.dto.GearboxDTO;
import com.example.javamasterproject.model.Gearbox;
import com.example.javamasterproject.service.GearboxService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/gearbox")
public class GearboxController {

    @Autowired
    private GearboxService gearboxService;

    @PostMapping("")
    public ResponseEntity<GearboxDTO> createGearbox(@RequestBody GearboxDTO gearbox) {
        String createdGearbox = gearboxService.createGearbox(gearbox);
        return ResponseEntity.status(HttpStatus.CREATED).body(gearboxService.getGearboxById(createdGearbox));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GearboxDTO> getGearboxById(@PathVariable String id) {
        GearboxDTO gearbox = gearboxService.getGearboxById(id);
        return ResponseEntity.ok(gearbox);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GearboxDTO>> getAllGearboxes() {
        List<GearboxDTO> gearboxes = gearboxService.getAllGearboxes();
        return ResponseEntity.ok(gearboxes);
    }

    @GetMapping("/all/userId={userId}")
    public ResponseEntity<List<GearboxDTO>> getAllGearboxesByUserId(@PathVariable String userId) {
        List<GearboxDTO> gearboxDTOS = gearboxService.getAllGearboxesByUserId(userId);
        return ResponseEntity.ok(gearboxDTOS);
    }
//    @GetMapping("/all/{name}")
//    public ResponseEntity<List<GearboxDTO>> getAllGearboxesByName(@PathVariable String name) {
//        List<GearboxDTO> gearboxes = gearboxService.getAllGearboxesByName(name);
//        return ResponseEntity.ok(gearboxes);
//    }
//
//    @GetMapping("/all/{transmission}")
//    public ResponseEntity<List<GearboxDTO>> getAllGearboxesByTransmission(@PathVariable String transmission) {
//        List<GearboxDTO> gearboxes = gearboxService.getAllGearboxesByTransmission(transmission);
//        return ResponseEntity.ok(gearboxes);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<GearboxDTO> updateGearbox(@PathVariable String id, @RequestBody GearboxDTO gearboxDTO) {
        gearboxDTO.setId(id);
        Gearbox updatedGearbox = gearboxService.updateGearbox(id, gearboxDTO);
        return ResponseEntity.ok(gearboxService.getGearboxById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteGearbox(@PathVariable String id) {
        gearboxService.deleteGearbox(id);
        return ResponseEntity.noContent().build();
    }
}
