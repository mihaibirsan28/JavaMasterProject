package com.example.javamasterproject.controller;

import com.example.javamasterproject.controller.EngineController;
import com.example.javamasterproject.dto.EngineDTO;
import com.example.javamasterproject.model.Engine;
import com.example.javamasterproject.service.EngineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EngineControllerTest {

    @Mock
    private EngineService engineService;

    @InjectMocks
    private EngineController engineController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateEngine() {
        EngineDTO engineDTO = new EngineDTO();
        engineDTO.setId("1");
        when(engineService.createEngine(any(EngineDTO.class))).thenReturn("1");
        when(engineService.getEngineById("1")).thenReturn(engineDTO);

        ResponseEntity<EngineDTO> response = engineController.createEngine(engineDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(engineDTO, response.getBody());
        verify(engineService, times(1)).createEngine(engineDTO);
        verify(engineService, times(1)).getEngineById("1");
    }

    @Test
    void testGetEngineById() {
        EngineDTO engineDTO = new EngineDTO();
        engineDTO.setId("1");
        when(engineService.getEngineById("1")).thenReturn(engineDTO);

        ResponseEntity<EngineDTO> response = engineController.getEngineById("1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(engineDTO, response.getBody());
        verify(engineService, times(1)).getEngineById("1");
    }

    @Test
    void testGetAllEngines() {
        List<EngineDTO> engines = Arrays.asList(new EngineDTO(), new EngineDTO());
        when(engineService.getAllEngines()).thenReturn(engines);

        ResponseEntity<List<EngineDTO>> response = engineController.getAllEngines();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(engines, response.getBody());
        verify(engineService, times(1)).getAllEngines();
    }

    @Test
    void testGetAllEnginesByUserId() {
        String userId = "user1";
        List<EngineDTO> engines = Arrays.asList(new EngineDTO(), new EngineDTO());
        when(engineService.getAllEnginesByUserId(userId)).thenReturn(engines);

        ResponseEntity<List<EngineDTO>> response = engineController.getAllEnginesByUserId(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(engines, response.getBody());
        verify(engineService, times(1)).getAllEnginesByUserId(userId);
    }

    @Test
    void testUpdateEngine() {
        String engineId = "1";
        EngineDTO engineDTO = new EngineDTO();
        engineDTO.setId(engineId);
        Engine updatedEngine = new Engine();
        when(engineService.updateEngine(engineId, engineDTO)).thenReturn(updatedEngine);
        when(engineService.getEngineById(engineId)).thenReturn(engineDTO);

        ResponseEntity<EngineDTO> response = engineController.updateEngine(engineId, engineDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(engineDTO, response.getBody());
        verify(engineService, times(1)).updateEngine(engineId, engineDTO);
        verify(engineService, times(1)).getEngineById(engineId);
    }

    @Test
    void testDeleteEngine() {
        String engineId = "1";

        ResponseEntity<Void> response = engineController.deleteEngine(engineId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(engineService, times(1)).deleteEngine(engineId);
    }
}
