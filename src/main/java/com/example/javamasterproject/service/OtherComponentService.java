package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.OtherComponentDTO;
import com.example.javamasterproject.mappers.OtherComponentMapper;
import com.example.javamasterproject.model.OtherComponent;
import com.example.javamasterproject.repository.OtherComponentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OtherComponentService {

    private final OtherComponentMapper otherComponentMapper;

    private final OtherComponentRepository otherComponentRepository;


    public String createOtherComponent(OtherComponentDTO otherComponentDTO) {
        OtherComponent otherComponent = otherComponentMapper.mapToOtherComponent(otherComponentDTO);
        otherComponentRepository.save(otherComponent);
        return otherComponent.getId();
    }

    public OtherComponentDTO getOtherComponentById(String id) {
        OtherComponent otherComponent = otherComponentRepository.findById(id).orElseThrow(() -> new RuntimeException("Component not found"));
        OtherComponentDTO otherComponentDTO = otherComponentMapper.mapToOtherComponentDTO(otherComponent);
        return otherComponentDTO;
    }

    public List<OtherComponentDTO> getAllOtherComponents() {
        List<OtherComponent> otherComponentEntities = otherComponentRepository.findAll();
        List<OtherComponentDTO> otherComponents = new ArrayList<>();
        for (OtherComponent otherComponent : otherComponentEntities) {
            otherComponents.add(otherComponentMapper.mapToOtherComponentDTO(otherComponent));
        }
        return otherComponents;
    }

    public List<OtherComponentDTO> getAllOtherComponentsByUserId(String userId) {
        List<OtherComponent> otherComponentsEntities = otherComponentRepository.findAllByUserId(userId);
        List<OtherComponentDTO> otherComponentDTOS = new ArrayList<>();
        for (OtherComponent otherComponent: otherComponentsEntities) {
            otherComponentDTOS.add(otherComponentMapper.mapToOtherComponentDTO(otherComponent));
        }
        return otherComponentDTOS;
    }

//    public List<OtherComponentDTO> getAllOtherComponentsByName(String name) {
//        List<OtherComponent> otherComponentEntities = otherComponentRepository.findAllByName(name);
//        List<OtherComponentDTO> otherComponents = new ArrayList<>();
//        for (OtherComponent otherComponent : otherComponentEntities) {
//            otherComponents.add(otherComponentMapper.mapToOtherComponentDTO(otherComponent));
//        }
//        return otherComponents;
//    }

    public OtherComponent updateOtherComponent(String id, OtherComponentDTO otherComponentDTO) {
        OtherComponent otherComponent = otherComponentMapper.mapToOtherComponent(otherComponentDTO);
        otherComponentRepository.save(otherComponent);
        return otherComponent;

//        Optional<OtherComponent> otherComponentOptional = otherComponentRepository.findById(id);
//        if ( otherComponentOptional.isPresent()) {
//            OtherComponent existingOtherComponent = otherComponentOptional.get();
//            existingOtherComponent.setName(otherComponent.getName());
//            existingOtherComponent.setDescription(otherComponent.getDescription());
//            existingOtherComponent.setPhotos(otherComponent.getPhotos());
//            existingOtherComponent.setCompatibility(otherComponent.getCompatibility());
//            existingOtherComponent.setCondition(otherComponent.getCondition());
//            existingOtherComponent.setMileage(otherComponent.getMileage());
//            return otherComponentRepository.save(existingOtherComponent);
//        }
//        else {
//            throw new RuntimeException("Component not found");
//        }
    }

    public void deleteOtherComponent(String id) {
        otherComponentRepository.deleteById(id);
    }

}
