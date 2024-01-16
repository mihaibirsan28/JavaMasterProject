package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.GearboxDTO;
import com.example.javamasterproject.mappers.GearboxMapper;
import com.example.javamasterproject.model.Gearbox;
import com.example.javamasterproject.repository.GearboxRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GearboxService {

    private final GearboxMapper gearboxMapper;

    private final GearboxRepository gearboxRepository;

    public String createGearbox(GearboxDTO gearboxDTO) {
        Gearbox gearbox = gearboxMapper.mapToGearbox(gearboxDTO);
        gearboxRepository.save(gearbox);
        return gearbox.getId();
    }

    public GearboxDTO getGearboxById(String id) {
        Gearbox gearbox = gearboxRepository.findById(id).orElseThrow(() -> new RuntimeException("Gearbox not found!"));
        GearboxDTO gearboxDTO = gearboxMapper.mapToGearboxDTO(gearbox);
        return gearboxDTO;
    }

    public List<GearboxDTO> getAllGearboxes() {
        List<Gearbox> gearboxEntities = gearboxRepository.findAll();
        List<GearboxDTO> gearboxes = new ArrayList<>();
        for (Gearbox gearbox : gearboxEntities) {
            gearboxes.add(gearboxMapper.mapToGearboxDTO(gearbox));
        }
        return gearboxes;
    }

    public List<GearboxDTO> getAllGearboxesByUserId(String userId) {
        List<Gearbox> gearboxeEntites = gearboxRepository.findAllByUserId(userId);
        List<GearboxDTO> gearboxDTOS = new ArrayList<>();
        for (Gearbox gearbox: gearboxeEntites) {
            gearboxDTOS.add(gearboxMapper.mapToGearboxDTO(gearbox));
        }
        return gearboxDTOS;
    }

//    public List<GearboxDTO> getAllGearboxesByName(String name) {
//        List<Gearbox> gearboxEntities = gearboxRepository.findAllByName(name);
//        List<GearboxDTO> gearboxes = new ArrayList<>();
//        for (Gearbox gearbox : gearboxEntities) {
//            gearboxes.add(gearboxMapper.mapToGearboxDTO(gearbox));
//        }
//        return gearboxes;
//    }
//
//    public List<GearboxDTO> getAllGearboxesByTransmission(String transmission) {
//        List<Gearbox> gearboxEntities = gearboxRepository.findAllByTransmission(transmission);
//        List<GearboxDTO> gearboxes = new ArrayList<>();
//        for (Gearbox gearbox : gearboxEntities) {
//            gearboxes.add(gearboxMapper.mapToGearboxDTO(gearbox));
//        }
//        return gearboxes;
//    }

    public Gearbox updateGearbox(String id, GearboxDTO gearboxDTO) {
        Gearbox gearbox = gearboxMapper.mapToGearbox(gearboxDTO);
        gearboxRepository.save(gearbox);
        return gearbox;
//        Optional<Gearbox> gearboxOptional = gearboxRepository.findById(id);
//        if (gearboxOptional.isPresent()) {
//            Gearbox existingGearbox = gearboxOptional.get();
//            existingGearbox.setName(gearbox.getName());
//            existingGearbox.setDescription(gearbox.getDescription());
//            existingGearbox.setPhotos(gearbox.getPhotos());
//            existingGearbox.setCompatibility(gearbox.getCompatibility());
//            existingGearbox.setCondition(gearbox.getCondition());
//            existingGearbox.setMileage(gearbox.getMileage());
//            existingGearbox.setGears(gearbox.getGears());
//            existingGearbox.setType(gearbox.getType());
//            existingGearbox.setTransmission(gearbox.getTransmission());
//            return gearboxRepository.save(existingGearbox);
//        }
//        else {
//            throw new RuntimeException("Gearbox not found");
//        }
    }

    public void deleteGearbox(String id) {
        gearboxRepository.deleteById(id);
    }
}
