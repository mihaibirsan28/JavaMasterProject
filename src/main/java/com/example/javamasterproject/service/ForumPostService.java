package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.ForumPostDTO;
import com.example.javamasterproject.mappers.ForumPostMapper;
import com.example.javamasterproject.model.ForumPost;
import com.example.javamasterproject.repository.ForumPostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ForumPostService {

    private final ForumPostMapper forumPostMapper;

    private final ForumPostRepository forumPostRepository;


    public String createForumPost(ForumPostDTO forumPostDTO) {
        ForumPost forumPost = forumPostMapper.mapToForumPost(forumPostDTO);
        forumPostRepository.save(forumPost);
        return forumPost.getId();
    }

    public ForumPostDTO getForumPostById(String id) {
        ForumPost forumPost = forumPostRepository.findById(id).orElseThrow(() -> new RuntimeException("Forum post not found"));
        ForumPostDTO forumPostDTO = forumPostMapper.mapToForumPostDTO(forumPost);
        return forumPostDTO;
    }

    public List<ForumPostDTO> getAllForumPosts() {
        List<ForumPost> forumPostEntities = forumPostRepository.findAll();
        List<ForumPostDTO> forumPosts = new ArrayList<>();
        for (ForumPost forumPost : forumPostEntities) {
            forumPosts.add(forumPostMapper.mapToForumPostDTO(forumPost));
        }
        return forumPosts;
    }

//    public List<ForumPostDTO> getAllForumPostsByTitle(String title) {
//        List<ForumPost> forumPostEntities = forumPostRepository.findAllByTitle(title);
//        List<ForumPostDTO> forumPosts = new ArrayList<>();
//        for (ForumPost forumPost : forumPostEntities) {
//            forumPosts.add(forumPostMapper.mapToForumPostDTO(forumPost));
//        }
//        return forumPosts;
//    }
//
    public List<ForumPostDTO> getAllForumPostsByTopicId(String topicId) {
        List<ForumPost> forumPostEntities = forumPostRepository.findAllByTopicId(topicId);
        List<ForumPostDTO> forumPosts = new ArrayList<>();
        for (ForumPost forumPost : forumPostEntities) {
            forumPosts.add(forumPostMapper.mapToForumPostDTO(forumPost));
        }
        return forumPosts;
    }
//
//    public List<ForumPostDTO> getAllForumPostsByUserId(int userId) {
//        List<ForumPost> forumPostEntities = forumPostRepository.findAllByUserId(userId);
//        List<ForumPostDTO> forumPosts = new ArrayList<>();
//        for (ForumPost forumPost : forumPostEntities) {
//            forumPosts.add(forumPostMapper.mapToForumPostDTO(forumPost));
//        }
//        return forumPosts;
//    }

    public ForumPost updateForumPost(String id, ForumPostDTO forumPostDTO) {
        ForumPost forumPost = forumPostMapper.mapToForumPost(forumPostDTO);
        forumPostRepository.save(forumPost);
        return forumPost;

    }

    public void deleteForumPost(String id) {
        forumPostRepository.deleteById(id);
    }
}
