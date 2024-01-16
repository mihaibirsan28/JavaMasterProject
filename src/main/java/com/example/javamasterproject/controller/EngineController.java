package com.example.javamasterproject.controller;

import com.example.javamasterproject.dto.EngineDTO;
import com.example.javamasterproject.model.Engine;
import com.example.javamasterproject.service.EngineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/engine")
public class EngineController {

    @Autowired
    private  EngineService engineService;


    @PostMapping("")
    public ResponseEntity<EngineDTO> createEngine(@RequestBody EngineDTO engine) {
        String createdEngine = engineService.createEngine(engine);
        return ResponseEntity.status(HttpStatus.CREATED).body(engineService.getEngineById(createdEngine));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EngineDTO> getEngineById(@PathVariable String id) {
        EngineDTO engine = engineService.getEngineById(id);
        return ResponseEntity.ok(engine);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EngineDTO>> getAllEngines() {
        List<EngineDTO> engines = engineService.getAllEngines();
        return ResponseEntity.ok(engines);
    }

    @GetMapping("/all/userId={userId}")
    public ResponseEntity<List<EngineDTO>> getAllEnginesByUserId(@PathVariable String userId) {
        List<EngineDTO> engines = engineService.getAllEnginesByUserId(userId);
        return ResponseEntity.ok(engines);
    }
//
//    @GetMapping("/all/{name}")
//    public ResponseEntity<List<EngineDTO>> getAllEnginesByName(@PathVariable String name) {
//        List<EngineDTO> engines = engineService.getAllEnginesByName(name);
//        return ResponseEntity.ok(engines);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<EngineDTO> updateEngine(@PathVariable String id, @RequestBody EngineDTO engineDTO) {
        engineDTO.setId(id);
        Engine updatedEngine = engineService.updateEngine(id, engineDTO);
        return ResponseEntity.ok(engineService.getEngineById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEngine(@PathVariable String id) {
        engineService.deleteEngine(id);
        return ResponseEntity.noContent().build();
    }
}
