package com.example.javamasterproject.controller;

import com.example.javamasterproject.dto.ForumPostDTO;
import com.example.javamasterproject.model.ForumPost;
import com.example.javamasterproject.service.ForumPostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/forum_post")
public class ForumPostController {

    @Autowired
    private  ForumPostService forumPostService;

    @PostMapping("")
    public ResponseEntity<ForumPostDTO> createForumPost(@RequestBody ForumPostDTO forumPost) {
        String createdForumPost = forumPostService.createForumPost(forumPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(forumPostService.getForumPostById(createdForumPost));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForumPostDTO> getForumPostById(@PathVariable String id) {
        ForumPostDTO forumPost = forumPostService.getForumPostById(id);
        return ResponseEntity.ok(forumPost);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ForumPostDTO>> getAllForumPosts() {
        List<ForumPostDTO> forumPosts = forumPostService.getAllForumPosts();
        return ResponseEntity.ok(forumPosts);
    }

//    @GetMapping("/all/{title}")
//    public ResponseEntity<List<ForumPostDTO>> getAllForumPostsByTitle(@PathVariable String title) {
//        List<ForumPostDTO> forumPosts = forumPostService.getAllForumPostsByTitle(title);
//        return ResponseEntity.ok(forumPosts);
//    }
//
    @GetMapping("/all/{topic_id}")
    public ResponseEntity<List<ForumPostDTO>> getAllForumPostsByTopicId(@PathVariable String topic_id) {
        List<ForumPostDTO> forumPosts = forumPostService.getAllForumPostsByTopicId(topic_id);
        return ResponseEntity.ok(forumPosts);
    }
//
//    @GetMapping("/all/{user_id}")
//    public ResponseEntity<List<ForumPostDTO>> getAllForumPostsByUserId(@PathVariable int user_id) {
//        List<ForumPostDTO> forumPosts = forumPostService.getAllForumPostsByUserId(user_id);
//        return ResponseEntity.ok(forumPosts);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ForumPostDTO> updateForumPost(@PathVariable String id, @RequestBody ForumPostDTO forumPostDTO) {
        forumPostDTO.setId(id);
        ForumPost updatedForumPost = forumPostService.updateForumPost(id, forumPostDTO);
        return ResponseEntity.ok(forumPostService.getForumPostById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForumPost(@PathVariable String id) {
        forumPostService.deleteForumPost(id);
        return ResponseEntity.noContent().build();
    }
}
