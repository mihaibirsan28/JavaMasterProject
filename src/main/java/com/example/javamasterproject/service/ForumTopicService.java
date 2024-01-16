package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.ForumTopicDTO;
import com.example.javamasterproject.mappers.ForumTopicMapper;
import com.example.javamasterproject.model.ForumTopic;
import com.example.javamasterproject.repository.ForumTopicRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ForumTopicService {

    private final ForumTopicMapper forumTopicMapper;

    private final ForumTopicRepository forumTopicRepository;


    public String createForumTopic(ForumTopicDTO forumTopicDTO) {
        ForumTopic forumTopic = forumTopicMapper.mapToForumTopic(forumTopicDTO);
        forumTopicRepository.save(forumTopic);
        return forumTopic.getId();
    }

    public ForumTopicDTO getForumTopicById(String id) {
        ForumTopic forumTopic = forumTopicRepository.findById(id).orElseThrow(() -> new RuntimeException("Forum topic not found"));
        ForumTopicDTO forumTopicDTO = forumTopicMapper.mapToForumTopicDTO(forumTopic);
        return forumTopicDTO;
    }

    public List<ForumTopicDTO> getAllForumTopics() {
        List<ForumTopic> forumTopicEntities = forumTopicRepository.findAll();
        List<ForumTopicDTO> forumTopics = new ArrayList<>();
        for (ForumTopic forumTopic : forumTopicEntities) {
            forumTopics.add(forumTopicMapper.mapToForumTopicDTO(forumTopic));
        }
        return forumTopics;
    }

//    public List<ForumTopicDTO> getAllForumTopicsByTitle(String title) {
//        List<ForumTopic> forumTopicEntities = forumTopicRepository.findAllByTitle(title);
//        List<ForumTopicDTO> forumTopics = new ArrayList<>();
//        for (ForumTopic forumTopic : forumTopicEntities) {
//            forumTopics.add(forumTopicMapper.mapToForumTopicDTO(forumTopic));
//        }
//        return forumTopics;
//    }
//
//    public List<ForumTopicDTO> getAllForumTopicsByUserId(int userId) {
//        List<ForumTopic> forumTopicEntities = forumTopicRepository.findAllByUserId(userId);
//        List<ForumTopicDTO> forumTopics = new ArrayList<>();
//        for (ForumTopic forumTopic : forumTopicEntities) {
//            forumTopics.add(forumTopicMapper.mapToForumTopicDTO(forumTopic));
//        }
//        return forumTopics;
//    }



    public ForumTopic updateForumTopic(String id, ForumTopicDTO forumTopicDTO) {
        ForumTopic forumTopic = forumTopicMapper.mapToForumTopic(forumTopicDTO);
        forumTopicRepository.save(forumTopic);
        return forumTopic;
//        Optional<ForumTopic> forumTopicOptional = forumTopicRepository.findById(id);
//        if (forumTopicOptional.isPresent()) {
//            ForumTopic existingForumTopic = forumTopicOptional.get();
//            existingForumTopic.setTitle(forumTopic.getTitle());
//            existingForumTopic.setCarId(forumTopic.getCarId());
//            return forumTopicRepository.save(existingForumTopic);
//        }
//        else {
//            throw new RuntimeException("Forum topic not found");
//        }
    }

    public void deleteForumTopic(String id) {
        forumTopicRepository.deleteById(id);
    }
}
