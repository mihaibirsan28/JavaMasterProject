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
        // Given
        UserDTO userDTO = new UserDTO(); // Create your DTO object here
        User expectedUser = new User();
        String expectedUserId = "123";

        // Mock the behavior of the dependencies
        when(userMapper.mapToUser(userDTO)).thenReturn(expectedUser);

        // Ensure that the save operation returns a non-null value
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            // You may want to set an ID on the saved user here if it's null
            savedUser.setId(expectedUserId);
            return savedUser;
        });

        // When
        String userId = userService.createUser(userDTO);

        // Then
        assertNotNull(userId, "User ID should not be null");
        assertEquals(expectedUserId, userId, "User ID should match"); // Optionally, check if the returned userId matches the expected value

        // Verify that the methods were called with the expected arguments
        verify(userMapper, times(1)).mapToUser(userDTO);
        verify(userRepository, times(1)).save(expectedUser);
    }

    @Test
    void testGetUserById() {
        // Given
        String userId = "123";
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userMapper.mapToUserDTO(user)).thenReturn(new UserDTO());

        // When
        UserDTO userDTO = userService.getUserById(userId);

        // Then
        assertNotNull(userDTO);
    }

    @Test
    void testGetUserById_UserNotFound() {
        // Given
        String userId = "123";
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // When, Then
        assertThrows(RuntimeException.class, () -> userService.getUserById(userId));
    }

    @Test
    void testGetUserByEmail() {
        // Given
        String email = "test@example.com";
        User user = new User();
        when(userRepository.getUserByEmail(email)).thenReturn(user);
        when(userMapper.mapToUserDTO(user)).thenReturn(new UserDTO());

        // When
        UserDTO userDTO = userService.getUserByEmail(email);

        // Then
        assertNotNull(userDTO);
    }

    @Test
    void testGetAllUsers() {
        // Given
        List<User> users = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(users);
        when(userMapper.mapToUserDTO(any(User.class))).thenReturn(new UserDTO());

        // When
        List<UserDTO> userDTOs = userService.getAllUsers();

        // Then
        assertEquals(users.size(), userDTOs.size());
    }

    @Test
    void testUpdateUser() {
        // Given
        String userId = "123";
        UserDTO userDTO = new UserDTO();
        User user = new User();
        when(userMapper.mapToUser(userDTO)).thenReturn(user);

        // When
        User updatedUser = userService.updateUser(userId, userDTO);

        // Then
        assertNotNull(updatedUser);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDeleteUser() {
        // Given
        String userId = "123";

        // When
        userService.deleteUser(userId);

        // Then
        verify(userRepository, times(1)).deleteById(userId);
    }
}
