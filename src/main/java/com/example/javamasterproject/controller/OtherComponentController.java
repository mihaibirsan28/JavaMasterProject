package com.example.javamasterproject.controller;

import com.example.javamasterproject.dto.OtherComponentDTO;
import com.example.javamasterproject.model.OtherComponent;
import com.example.javamasterproject.service.OtherComponentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/other_component")
public class OtherComponentController {

    @Autowired
    private OtherComponentService otherComponentService;

    @PostMapping("")
    public ResponseEntity<OtherComponentDTO> createOtherComponent(@RequestBody OtherComponentDTO otherComponent) {
        String createdOtherComponent = otherComponentService.createOtherComponent(otherComponent);
        return ResponseEntity.status(HttpStatus.CREATED).body(otherComponentService.getOtherComponentById(createdOtherComponent));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherComponentDTO> getOtherComponentById(@PathVariable String id) {
        OtherComponentDTO otherComponent = otherComponentService.getOtherComponentById(id);
        return ResponseEntity.ok(otherComponent);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OtherComponentDTO>> getAllOtherComponents() {
        List<OtherComponentDTO> otherComponets = otherComponentService.getAllOtherComponents();
        return ResponseEntity.ok(otherComponets);
    }

    @GetMapping("/all/userId={userId}")
    public ResponseEntity<List<OtherComponentDTO>> getAllOtherComponentsByUserId(@PathVariable String userId) {
        List<OtherComponentDTO> otherComponentDTOS = otherComponentService.getAllOtherComponentsByUserId(userId);
        return ResponseEntity.ok(otherComponentDTOS);
    }

//    @GetMapping("/all/{name}")
//    public ResponseEntity<List<OtherComponentDTO>> getAllOtherComponentsByName(@PathVariable String name) {
//        List<OtherComponentDTO> otherComponets = otherComponentService.getAllOtherComponentsByName(name);
//        return ResponseEntity.ok(otherComponets);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<OtherComponentDTO> updateOtherComponent(@PathVariable String id, @RequestBody OtherComponentDTO otherComponentDTO) {
        otherComponentDTO.setId(id);
        OtherComponent updatedOtherComponent = otherComponentService.updateOtherComponent(id, otherComponentDTO);
        return ResponseEntity.ok(otherComponentService.getOtherComponentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOtherComponent(@PathVariable String id) {
        otherComponentService.deleteOtherComponent(id);
        return ResponseEntity.noContent().build();
    }
}
