package com.example.javamasterproject.controller;

import com.example.javamasterproject.dto.ForumCommentDTO;
import com.example.javamasterproject.model.ForumComment;
import com.example.javamasterproject.service.ForumCommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/forum_comment")
public class ForumCommentController {

    @Autowired
    private ForumCommentService forumCommentService;


    @PostMapping("")
    public ResponseEntity<ForumCommentDTO> createForumComment(@RequestBody ForumCommentDTO forumComment) {
        String createdForumComment = forumCommentService.createForumComment(forumComment);
        return ResponseEntity.status(HttpStatus.CREATED).body(forumCommentService.getForumCommentById(createdForumComment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForumCommentDTO> getForumCommentById(@PathVariable String id) {
        ForumCommentDTO forumComment = forumCommentService.getForumCommentById(id);
        return ResponseEntity.ok(forumComment);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ForumCommentDTO>> getAllForumComments() {
        List<ForumCommentDTO> forumComments = forumCommentService.getAllForumComments();
        return ResponseEntity.ok(forumComments);
    }

    @GetMapping("/all/{post_id}")
    public ResponseEntity<List<ForumCommentDTO>> getAllForumCommentsByPostId(@PathVariable String post_id) {
        List<ForumCommentDTO> forumComments = forumCommentService.getAllForumCommentsByPostId(post_id);
        return ResponseEntity.ok(forumComments);
    }
//
//    @GetMapping("/all/{user_id}")
//    public ResponseEntity<List<ForumCommentDTO>> getAllForumCommentsByUserId(@PathVariable int user_id) {
//        List<ForumCommentDTO> forumComments = forumCommentService.getAllForumCommentsByUserId(user_id);
//        return ResponseEntity.ok(forumComments);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ForumCommentDTO> updateForumComment(@PathVariable String id, @RequestBody ForumCommentDTO forumCommentDTO) {
        forumCommentDTO.setId(id);
        ForumComment updatedForumComment = forumCommentService.updateForumComment(id, forumCommentDTO);
        return ResponseEntity.ok(forumCommentService.getForumCommentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForumComment(@PathVariable String id) {
        forumCommentService.deleteForumPost(id);
        return ResponseEntity.noContent().build();
    }
}
