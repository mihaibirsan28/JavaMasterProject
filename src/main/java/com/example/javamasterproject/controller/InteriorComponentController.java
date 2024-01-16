package com.example.javamasterproject.controller;

import com.example.javamasterproject.dto.InteriorComponentDTO;
import com.example.javamasterproject.model.InteriorComponent;
import com.example.javamasterproject.service.InteriorComponentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/interior_component")
public class InteriorComponentController {

    @Autowired
    private InteriorComponentService interiorComponentService;

    @PostMapping("")
    public ResponseEntity<InteriorComponentDTO> createInteriorComponent(@RequestBody InteriorComponentDTO interiorComponent) {
        String createdInteriorComponent = interiorComponentService.createInteriorComponent(interiorComponent);
        return ResponseEntity.status(HttpStatus.CREATED).body(interiorComponentService.getInteriorComponentById(createdInteriorComponent));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteriorComponentDTO> getInteriorComponentById(@PathVariable String id) {
        InteriorComponentDTO interiorComponent = interiorComponentService.getInteriorComponentById(id);
        return ResponseEntity.ok(interiorComponent);
    }

    @GetMapping("/all")
    public ResponseEntity<List<InteriorComponentDTO>> getAllInteriorComponents() {
        List<InteriorComponentDTO> interiorComponents = interiorComponentService.getAllInteriorComponents();
        return ResponseEntity.ok(interiorComponents);
    }

    @GetMapping("/all/userId={userId}")
    public ResponseEntity<List<InteriorComponentDTO>> getAllInteriorComponentsByUserId(@PathVariable String userId) {
        List<InteriorComponentDTO> interiorComponentDTOS = interiorComponentService.getAllInteriorComponentsByUserId(userId);
        return ResponseEntity.ok(interiorComponentDTOS);
    }

//    @GetMapping("/all/{name}")
//    public ResponseEntity<List<InteriorComponentDTO>> getAllInteriorComponentsByName(@PathVariable String name) {
//        List<InteriorComponentDTO> interiorComponents = interiorComponentService.getAllInteriorComponentsByName(name);
//        return ResponseEntity.ok(interiorComponents);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<InteriorComponentDTO> updateInteriorComponent(@PathVariable String id, @RequestBody InteriorComponentDTO interiorComponentDTO) {
        interiorComponentDTO.setId(id);
        InteriorComponent updatedInteriorComponent = interiorComponentService.updateInteriorComponent(id, interiorComponentDTO);
        return ResponseEntity.ok(interiorComponentService.getInteriorComponentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInteriorComponent(@PathVariable String id) {
        interiorComponentService.deleteInteriorComponent(id);
        return ResponseEntity.noContent().build();
    }
}
