package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.EngineDTO;
import com.example.javamasterproject.mappers.EngineMapper;
import com.example.javamasterproject.model.Engine;
import com.example.javamasterproject.repository.EngineRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EngineService {

    private final EngineMapper engineMapper;

    private final EngineRepository engineRepository;

    public String createEngine(EngineDTO engineDTO) {
        Engine engine = engineMapper.mapToEngine(engineDTO);
        engineRepository.save(engine);
        return engine.getId();
    }

    public EngineDTO getEngineById(String id) {
        Engine engine = engineRepository.findById(id).orElseThrow(() -> new RuntimeException("Engine not found"));
        EngineDTO engineDTO = engineMapper.mapToEngineDTO(engine);
        return engineDTO;
    }

    public List<EngineDTO> getAllEngines() {
        List<Engine> engineEntities = engineRepository.findAll();
        List<EngineDTO> engines = new ArrayList<>();
        for (Engine engine: engineEntities) {
            engines.add(engineMapper.mapToEngineDTO(engine));
        }
        return engines;
    }

    public List<EngineDTO> getAllEnginesByUserId(String userId) {
        List<Engine> engineEntities = engineRepository.findAllByUserId(userId);
        List<EngineDTO> engines = new ArrayList<>();
        for (Engine engine: engineEntities) {
            engines.add(engineMapper.mapToEngineDTO(engine));
        }
        return engines;
    }

//    public List<EngineDTO> getAllEnginesByName(String name) {
//        List<Engine> engineEntities = engineRepository.findAllByName(name);
//        List<EngineDTO> engines = new ArrayList<>();
//        for (Engine engine: engineEntities) {
//            engines.add(engineMapper.mapToEngineDTO(engine));
//        }
//        return engines;
//    }

    public Engine updateEngine(String id, EngineDTO engineDTO) {
        Engine engine = engineMapper.mapToEngine(engineDTO);
//        Optional<Engine> engineOptional = engineRepository.findById(id);
        engineRepository.save(engine);
        return engine;
//        if (engineOptional.isPresent()) {
//            Engine existingEngine = engineOptional.get();
//            existingEngine.setSize(engine.getSize());
//            existingEngine.setFuel(engine.getFuel());
//            existingEngine.setNumberOfCylindres(engine.getNumberOfCylindres());
//            existingEngine.setCode(existingEngine.getCode());
//            return engineRepository.save(existingEngine);
//        }
//        else {
//            throw new RuntimeException("Engine not found");
//        }
    }

    public void deleteEngine(String id) {
        engineRepository.deleteById(id);
    }

}
