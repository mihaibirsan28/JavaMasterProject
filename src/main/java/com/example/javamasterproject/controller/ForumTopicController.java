package com.example.javamasterproject.controller;

import com.example.javamasterproject.dto.ForumTopicDTO;
import com.example.javamasterproject.model.ForumTopic;
import com.example.javamasterproject.service.ForumTopicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/forum_topic")
public class ForumTopicController {

    @Autowired
    private ForumTopicService forumTopicService;


    @PostMapping("")
    public ResponseEntity<ForumTopicDTO> createForumTopic(@RequestBody ForumTopicDTO forumTopicDTO) {
        String createdForumTopic = forumTopicService.createForumTopic(forumTopicDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(forumTopicService.getForumTopicById(createdForumTopic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForumTopicDTO> getForumTopicById(@PathVariable String id) {
        ForumTopicDTO forumTopic = forumTopicService.getForumTopicById(id);
        return ResponseEntity.ok(forumTopic);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ForumTopicDTO>> getAllForumTopics() {
        List<ForumTopicDTO> forumTopics = forumTopicService.getAllForumTopics();
        return ResponseEntity.ok(forumTopics);
    }

//    @GetMapping("/all/{title}")
//    public ResponseEntity<List<ForumTopicDTO>> getAllForumTopicsByTitle(@PathVariable String title) {
//        List<ForumTopicDTO> forumTopics = forumTopicService.getAllForumTopicsByTitle(title);
//        return ResponseEntity.ok(forumTopics);
//    }
//
//    @GetMapping("/all/{user_id}")
//    public ResponseEntity<List<ForumTopicDTO>> getAllForumTopicsByUserId(@PathVariable int user_id) {
//        List<ForumTopicDTO> forumTopics = forumTopicService.getAllForumTopicsByUserId(user_id);
//        return ResponseEntity.ok(forumTopics);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ForumTopicDTO> updateForumTopic(@PathVariable String id, @RequestBody ForumTopicDTO forumTopicDTO) {
        forumTopicDTO.setId(id);
        ForumTopic ForumTopic = forumTopicService.updateForumTopic(id, forumTopicDTO);
        return ResponseEntity.ok(forumTopicService.getForumTopicById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForumTopic(@PathVariable String id) {
        forumTopicService.deleteForumTopic(id);
        return ResponseEntity.noContent().build();
    }
}
