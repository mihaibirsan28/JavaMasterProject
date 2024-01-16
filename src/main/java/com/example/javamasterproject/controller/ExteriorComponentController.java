package com.example.javamasterproject.controller;

import com.example.javamasterproject.dto.ExteriorComponentDTO;
import com.example.javamasterproject.model.ExteriorComponent;
import com.example.javamasterproject.service.ExteriorComponentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/exterior_component")
public class ExteriorComponentController {

    @Autowired
    private ExteriorComponentService exteriorComponentService;

    @PostMapping("")
    public ResponseEntity<ExteriorComponentDTO> createExteriorComponent(@RequestBody ExteriorComponentDTO exteriorComponentDTO) {
        String createdExteriorComponent = exteriorComponentService.createExteriorComponent(exteriorComponentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(exteriorComponentService.getExteriorComponentById(createdExteriorComponent));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExteriorComponentDTO> getExteriorComponentById(@PathVariable String id) {
        ExteriorComponentDTO exteriorComponent = exteriorComponentService.getExteriorComponentById(id);
        return ResponseEntity.ok(exteriorComponent);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExteriorComponentDTO>> getAllExteriorComponents() {
        List<ExteriorComponentDTO> exteriorComponents = exteriorComponentService.getAllExteriorComponents();
        return ResponseEntity.ok(exteriorComponents);
    }

    @GetMapping("/all/userId={userId}")
    public ResponseEntity<List<ExteriorComponentDTO>> getAllExteriorComponentsByUserId(@PathVariable String userId) {
        List<ExteriorComponentDTO> exteriorComponentDTOS = exteriorComponentService.getAllExteriorComponentsByUserId(userId);
        return ResponseEntity.ok(exteriorComponentDTOS);
    }
//    @GetMapping("/all/{name}")
//    public ResponseEntity<List<ExteriorComponentDTO>> getAllExteriorComponentsByName(@PathVariable String name) {
//        List<ExteriorComponentDTO> exteriorComponents = exteriorComponentService.getAllExteriorComponetsByName(name);
//        return ResponseEntity.ok(exteriorComponents);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ExteriorComponentDTO> updateExteriorComponent(@PathVariable String id, @RequestBody ExteriorComponentDTO exteriorComponentDTO) {
        exteriorComponentDTO.setId(id);
        ExteriorComponent exteriorComponent = exteriorComponentService.updateExteriorComponent(id, exteriorComponentDTO);
        return ResponseEntity.ok(exteriorComponentService.getExteriorComponentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExteriorComponent(@PathVariable String id) {
        exteriorComponentService.deleteExteriorComponent(id);
        return ResponseEntity.noContent().build();
    }
}
