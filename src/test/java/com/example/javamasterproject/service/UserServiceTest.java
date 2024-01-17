package com.example.javamasterproject.service;

import com.example.javamasterproject.dto.UserDTO;
import com.example.javamasterproject.mappers.UserMapper;
import com.example.javamasterproject.model.User;
import com.example.javamasterproject.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        UserDTO userDTO = new UserDTO();
        User expectedUser = new User();
        String expectedUserId = "123";

        when(userMapper.mapToUser(userDTO)).thenReturn(expectedUser);

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            savedUser.setId(expectedUserId);
            return savedUser;
        });


        String userId = userService.createUser(userDTO);

        assertNotNull(userId, "User ID should not be null");
        assertEquals(expectedUserId, userId, "User ID should match");

        verify(userMapper, times(1)).mapToUser(userDTO);
        verify(userRepository, times(1)).save(expectedUser);
    }

    @Test
    void testGetUserById() {
        String userId = "123";
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userMapper.mapToUserDTO(user)).thenReturn(new UserDTO());

        UserDTO userDTO = userService.getUserById(userId);

        assertNotNull(userDTO);
    }

    @Test
    void testGetUserById_UserNotFound() {
        String userId = "123";
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.getUserById(userId));
    }

    @Test
    void testGetUserByEmail() {
        String email = "test@example.com";
        User user = new User();
        when(userRepository.getUserByEmail(email)).thenReturn(user);
        when(userMapper.mapToUserDTO(user)).thenReturn(new UserDTO());

        UserDTO userDTO = userService.getUserByEmail(email);

        assertNotNull(userDTO);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(users);
        when(userMapper.mapToUserDTO(any(User.class))).thenReturn(new UserDTO());

        List<UserDTO> userDTOs = userService.getAllUsers();

        assertEquals(users.size(), userDTOs.size());
    }

    @Test
    void testUpdateUser() {
        String userId = "123";
        UserDTO userDTO = new UserDTO();
        User user = new User();
        when(userMapper.mapToUser(userDTO)).thenReturn(user);

        User updatedUser = userService.updateUser(userId, userDTO);

        assertNotNull(updatedUser);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDeleteUser() {
        String userId = "123";

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }
}
