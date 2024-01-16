package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.ExteriorComponentDTO;
import com.example.javamasterproject.mappers.ExteriorComponentMapper;
import com.example.javamasterproject.model.ExteriorComponent;
import com.example.javamasterproject.repository.ExteriorComponentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExteriorComponentService {

    private final ExteriorComponentMapper exteriorComponentMapper;

    private final ExteriorComponentRepository exteriorComponentRepository;

    public String createExteriorComponent(ExteriorComponentDTO exteriorComponentDTO) {
        ExteriorComponent exteriorComponent = exteriorComponentMapper.mapToExteriorComponent(exteriorComponentDTO);
        exteriorComponentRepository.save(exteriorComponent);
        return exteriorComponent.getId();
    }

    public ExteriorComponentDTO getExteriorComponentById(String id) {
        ExteriorComponent exteriorComponent = exteriorComponentRepository.findById(id).orElseThrow(() -> new RuntimeException("Exterior component not found"));
        ExteriorComponentDTO exteriorComponentDTO = exteriorComponentMapper.mapToExteriorComponentDTO(exteriorComponent);
        return exteriorComponentDTO;
    }

    public List<ExteriorComponentDTO> getAllExteriorComponents() {
        List<ExteriorComponent> exteriorComponentEntities = exteriorComponentRepository.findAll();
        List<ExteriorComponentDTO> exteriorComponents = new ArrayList<>();
        for (ExteriorComponent exteriorComponent: exteriorComponentEntities) {
            exteriorComponents.add(exteriorComponentMapper.mapToExteriorComponentDTO(exteriorComponent));
        }
        return exteriorComponents;
    }

    public List<ExteriorComponentDTO> getAllExteriorComponentsByUserId(String userId) {
        List<ExteriorComponent> exteriorComponents = exteriorComponentRepository.findAllByUserId(userId);
        List<ExteriorComponentDTO> exteriorComponentDTOS = new ArrayList<>();
        for (ExteriorComponent exteriorComponent: exteriorComponents) {
            exteriorComponentDTOS.add(exteriorComponentMapper.mapToExteriorComponentDTO(exteriorComponent));
        }
        return exteriorComponentDTOS;
    }

//    public List<ExteriorComponentDTO> getAllExteriorComponetsByName(String name) {
//        List<ExteriorComponent> exteriorComponentEntities = exteriorComponentRepository.findAllByName(name);
//        List<ExteriorComponentDTO> exteriorComponents = new ArrayList<>();
//        for (ExteriorComponent exteriorComponent: exteriorComponentEntities) {
//            exteriorComponents.add(exteriorComponentMapper.mapToExteriorComponentDTO(exteriorComponent));
//        }
//        return exteriorComponents;
//    }

    public ExteriorComponent updateExteriorComponent(String id, ExteriorComponentDTO exteriorComponentDTO) {
        ExteriorComponent exteriorComponent = exteriorComponentMapper.mapToExteriorComponent(exteriorComponentDTO);
        exteriorComponentRepository.save(exteriorComponent);
        return exteriorComponent;
//        Optional<ExteriorComponent> exteriorComponentOptional = exteriorComponentRepository.findById(id);
//        if (exteriorComponentOptional.isPresent()) {
//            ExteriorComponent existingExteriorComponent = exteriorComponentOptional.get();
//            existingExteriorComponent.setName(exteriorComponent.getName());
//            existingExteriorComponent.setDescription(exteriorComponent.getDescription());
//            existingExteriorComponent.setPhotos(exteriorComponent.getPhotos());
//            existingExteriorComponent.setCompatibility(exteriorComponent.getCompatibility());
//            existingExteriorComponent.setCondition(exteriorComponent.getCondition());
//            existingExteriorComponent.setMileage(exteriorComponent.getMileage());
//            existingExteriorComponent.setMaterial(exteriorComponent.getMaterial());
//            existingExteriorComponent.setColor(exteriorComponent.getColor());
//            existingExteriorComponent.setFinish(exteriorComponent.getFinish());
//            existingExteriorComponent.setPlacement(exteriorComponent.getPlacement());
//            return exteriorComponentRepository.save(existingExteriorComponent);
//        }
//        else {
//            throw new RuntimeException("Exterior component not found");
//        }
    }

    public void deleteExteriorComponent(String id) {
        exteriorComponentRepository.deleteById(id);
    }

}
