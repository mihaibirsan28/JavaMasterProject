package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.EngineDTO;
import com.example.javamasterproject.mappers.EngineMapper;
import com.example.javamasterproject.model.Engine;
import com.example.javamasterproject.repository.EngineRepository;
import com.example.javamasterproject.service.EngineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EngineServiceTest {

    @Mock
    private EngineMapper engineMapper;

    @Mock
    private EngineRepository engineRepository;

    @InjectMocks
    private EngineService engineService;

    @Test
    void createEngine() {
        // Given
        EngineDTO engineDTO = new EngineDTO(); // Create your DTO object here
        Engine expectedEngine = new Engine();
        String expectedEngineId = "123";

        // Mock the behavior of the dependencies
        // Mock the behavior of the dependencies
        when(engineMapper.mapToEngine(engineDTO)).thenReturn(expectedEngine);

        // Ensure that the save operation returns a non-null value
        when(engineRepository.save(any(Engine.class))).thenAnswer(invocation -> {
            Engine savedEngine = invocation.getArgument(0);
            // You may want to set an ID on the saved engine here if it's null
            savedEngine.setId(expectedEngineId);
            return savedEngine;
        });

        // When
        String engineId = engineService.createEngine(engineDTO);

        // Then
        assertNotNull(engineId, "Engine ID should not be null");
        assertEquals(expectedEngineId, engineId, "Engine ID should match"); // Optionally, check if the returned engineId matches the expected value

        // Verify that the methods were called with the expected arguments
        verify(engineMapper, times(1)).mapToEngine(engineDTO);
        verify(engineRepository, times(1)).save(expectedEngine);
    }


    @Test
    void getEngineById() {
        String engineId = "123";
        Engine engine = new Engine();
        EngineDTO expectedEngineDTO = new EngineDTO();

        when(engineRepository.findById(engineId)).thenReturn(Optional.of(engine));
        when(engineMapper.mapToEngineDTO(engine)).thenReturn(expectedEngineDTO);

        EngineDTO result = engineService.getEngineById(engineId);

        assertNotNull(result);
        assertEquals(expectedEngineDTO, result);
        verify(engineRepository, times(1)).findById(engineId);
        verify(engineMapper, times(1)).mapToEngineDTO(engine);
    }

    @Test
    void getAllEngines() {
        List<Engine> engineEntities = Arrays.asList(new Engine(), new Engine());
        List<EngineDTO> expectedEngines = Arrays.asList(new EngineDTO(), new EngineDTO());

        when(engineRepository.findAll()).thenReturn(engineEntities);
        when(engineMapper.mapToEngineDTO(any(Engine.class))).thenReturn(new EngineDTO());

        List<EngineDTO> result = engineService.getAllEngines();

        assertNotNull(result);
        assertEquals(expectedEngines.size(), result.size());
        verify(engineRepository, times(1)).findAll();
        verify(engineMapper, times(engineEntities.size())).mapToEngineDTO(any(Engine.class));
    }

    @Test
    void getAllEnginesByUserId() {
        String userId = "user123";
        List<Engine> engineEntities = Arrays.asList(new Engine(), new Engine());
        List<EngineDTO> expectedEngines = Arrays.asList(new EngineDTO(), new EngineDTO());

        when(engineRepository.findAllByUserId(userId)).thenReturn(engineEntities);
        when(engineMapper.mapToEngineDTO(any(Engine.class))).thenReturn(new EngineDTO());

        List<EngineDTO> result = engineService.getAllEnginesByUserId(userId);

        assertNotNull(result);
        assertEquals(expectedEngines.size(), result.size());
        verify(engineRepository, times(1)).findAllByUserId(userId);
        verify(engineMapper, times(engineEntities.size())).mapToEngineDTO(any(Engine.class));
    }

    @Test
    public void testUpdateEngine() {
        // Arrange
        EngineMapper engineMapper = mock(EngineMapper.class);
        EngineRepository engineRepository = mock(EngineRepository.class);

        EngineService engineService = new EngineService(engineMapper, engineRepository);

        String engineId = "123";
        EngineDTO engineDTO = new EngineDTO(/* set DTO properties */);

        Engine mappedEngine = new Engine(/* set mapped engine properties */);
        when(engineMapper.mapToEngine(engineDTO)).thenReturn(mappedEngine);

        // Act
        Engine result = engineService.updateEngine(engineId, engineDTO);

        // Assert
        assertNotNull(result);
        assertEquals(mappedEngine, result);

        // Verify that the save method was called with the mapped engine
        verify(engineRepository, times(1)).save(mappedEngine);
    }
    @Test
    void deleteEngine() {
        String engineId = "123";

        engineService.deleteEngine(engineId);

        verify(engineRepository, times(1)).deleteById(engineId);
    }
}
