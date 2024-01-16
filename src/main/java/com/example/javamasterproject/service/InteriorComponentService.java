package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.InteriorComponentDTO;
import com.example.javamasterproject.mappers.InteriorComponentMapper;
import com.example.javamasterproject.model.InteriorComponent;
import com.example.javamasterproject.repository.InteriorComponentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InteriorComponentService {

    private final InteriorComponentMapper interiorComponentMapper;

    private final InteriorComponentRepository interiorComponentRepository;

    public String createInteriorComponent(InteriorComponentDTO interiorComponentDTO) {
        InteriorComponent interiorComponent = interiorComponentMapper.mapToInteriorComponent(interiorComponentDTO);
        interiorComponentRepository.save(interiorComponent);
        return interiorComponent.getId();
    }

    public InteriorComponentDTO getInteriorComponentById(String id) {
        InteriorComponent interiorComponent = interiorComponentRepository.findById(id).orElseThrow(() -> new RuntimeException("Interior compenent not found"));
        InteriorComponentDTO interiorComponentDTO = interiorComponentMapper.mapToInteriorComponentDTO(interiorComponent);
        return interiorComponentDTO;
    }

    public List<InteriorComponentDTO> getAllInteriorComponents() {
        List<InteriorComponent> interiorComponentEntities = interiorComponentRepository.findAll();
        List<InteriorComponentDTO> interiorComponents = new ArrayList<>();
        for (InteriorComponent interiorComponent : interiorComponentEntities) {
            interiorComponents.add(interiorComponentMapper.mapToInteriorComponentDTO(interiorComponent));
        }
        return interiorComponents;
    }

    public List<InteriorComponentDTO> getAllInteriorComponentsByUserId(String userId) {
        List<InteriorComponent> interiorComponentsEntities = interiorComponentRepository.findAllByUserId(userId);
        List<InteriorComponentDTO> interiorComponentDTOS = new ArrayList<>();
        for (InteriorComponent interiorComponent: interiorComponentsEntities) {
            interiorComponentDTOS.add(interiorComponentMapper.mapToInteriorComponentDTO(interiorComponent));
        }
        return interiorComponentDTOS;
    }

//    public List<InteriorComponentDTO> getAllInteriorComponentsByName(String name) {
//        List<InteriorComponent> interiorComponentEntities = interiorComponentRepository.findAllByName(name);
//        List<InteriorComponentDTO> interiorComponents = new ArrayList<>();
//        for (InteriorComponent interiorComponent : interiorComponentEntities) {
//            interiorComponents.add(interiorComponentMapper.mapToInteriorComponentDTO(interiorComponent));
//        }
//        return interiorComponents;
//    }

    public InteriorComponent updateInteriorComponent(String id, InteriorComponentDTO interiorComponentDTO) {
        InteriorComponent interiorComponent = interiorComponentMapper.mapToInteriorComponent(interiorComponentDTO);
        interiorComponentRepository.save(interiorComponent);
        return interiorComponent;
//        Optional<InteriorComponent> interiorComponentOptional = interiorComponentRepository.findById(id);
//        if (interiorComponentOptional.isPresent()) {
//            InteriorComponent existingInteriorComponent = interiorComponentOptional.get();
//            existingInteriorComponent.setName(interiorComponent.getName());
//            existingInteriorComponent.setDescription(interiorComponent.getDescription());
//            existingInteriorComponent.setPhotos(interiorComponent.getPhotos());
//            existingInteriorComponent.setCompatibility(interiorComponent.getCompatibility());
//            existingInteriorComponent.setCondition(interiorComponent.getCondition());
//            existingInteriorComponent.setMileage(interiorComponent.getMileage());
//            existingInteriorComponent.setMaterial(interiorComponent.getMaterial());
//            existingInteriorComponent.setColor(interiorComponent.getColor());
//            return interiorComponentRepository.save(existingInteriorComponent);
//        }
//        else {
//            throw new RuntimeException("Interior component not found");
//        }
    }

    public void deleteInteriorComponent(String id) {
        interiorComponentRepository.deleteById(id);
    }

}
