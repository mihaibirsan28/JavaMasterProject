package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.UserDTO;
import com.example.javamasterproject.mappers.UserMapper;
import com.example.javamasterproject.model.User;
import com.example.javamasterproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    public String createUser(UserDTO userDTO) {
        User user = userMapper.mapToUser(userDTO);
        userRepository.save(user);
        return user.getId();
    }

    public UserDTO getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        UserDTO userDTO = userMapper.mapToUserDTO(user);
        return userDTO;
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        UserDTO userDTO = userMapper.mapToUserDTO(user);
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        List<User> userEntities = userRepository.findAll();
        List<UserDTO> users = new ArrayList<>();
        for (User user: userEntities) {
            users.add(userMapper.mapToUserDTO(user));
        }
        return users;
    }

    public User updateUser(String id, UserDTO userDTO) {
        User user = userMapper.mapToUser(userDTO);
        userRepository.save(user);
        return user;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
