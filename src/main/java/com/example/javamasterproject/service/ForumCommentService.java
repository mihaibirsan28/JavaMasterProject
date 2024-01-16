package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.ForumCommentDTO;
import com.example.javamasterproject.mappers.ForumCommentMapper;
import com.example.javamasterproject.model.ForumComment;
import com.example.javamasterproject.repository.ForumCommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ForumCommentService {

    private final ForumCommentMapper forumCommentMapper;

    private final ForumCommentRepository forumCommentRepository;

    public String createForumComment(ForumCommentDTO forumCommentDTO) {
        ForumComment forumComment = forumCommentMapper.mapToForumComment(forumCommentDTO);
        forumCommentRepository.save(forumComment);
        return forumComment.getId();
    }

    public ForumCommentDTO getForumCommentById(String id) {
        ForumComment forumComment = forumCommentRepository.findById(id).orElseThrow(() -> new RuntimeException("Forum comment not found"));
        ForumCommentDTO forumCommentDTO = forumCommentMapper.mapToForumCommentDTO(forumComment);
        return forumCommentDTO;
    }

    public List<ForumCommentDTO> getAllForumComments() {
        List<ForumComment> forumCommentEntities = forumCommentRepository.findAll();
        List<ForumCommentDTO> forumComments = new ArrayList<>();
        for (ForumComment forumComment: forumCommentEntities) {
            forumComments.add(forumCommentMapper.mapToForumCommentDTO(forumComment));
        }
        return forumComments;
    }

    public List<ForumCommentDTO> getAllForumCommentsByPostId(String postId) {
        List<ForumComment> forumCommentEntities = forumCommentRepository.findAllByPostId(postId);
        List<ForumCommentDTO> forumComments = new ArrayList<>();
        for (ForumComment forumComment: forumCommentEntities) {
            forumComments.add(forumCommentMapper.mapToForumCommentDTO(forumComment));
        }
        return forumComments;
    }
//
//    public List<ForumCommentDTO> getAllForumCommentsByUserId(int userId) {
//        List<ForumComment> forumCommentEntities = forumCommentRepository.findAllByUserId(userId);
//        List<ForumCommentDTO> forumComments = new ArrayList<>();
//        for (ForumComment forumComment: forumCommentEntities) {
//            forumComments.add(forumCommentMapper.mapToForumCommentDTO(forumComment));
//        }
//        return forumComments;
//    }

    public ForumComment updateForumComment(String id, ForumCommentDTO forumCommentDTO) {
        ForumComment forumComment = forumCommentMapper.mapToForumComment(forumCommentDTO);
        forumCommentRepository.save(forumComment);
        return forumComment;
//        Optional<ForumComment> forumCommentOptional = forumCommentRepository.findById(id);
//        if (forumCommentOptional.isPresent()) {
//            ForumComment existingForumComment = forumCommentOptional.get();
//            existingForumComment.setContent(forumComment.getContent());
//            return forumCommentRepository.save(existingForumComment);
//        }
//        else {
//            throw new RuntimeException("Forum comment not found");
//        }
    }

    public void deleteForumPost(String id) {
        forumCommentRepository.deleteById(id);
    }
}
