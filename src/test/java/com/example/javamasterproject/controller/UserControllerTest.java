package com.example.javamasterproject.controller;

import com.example.javamasterproject.dto.UserDTO;
import com.example.javamasterproject.model.User;
import com.example.javamasterproject.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateUser() {
        UserDTO userDTO = new UserDTO();
        when(userService.createUser(userDTO)).thenReturn("userId");
        when(userService.getUserById("userId")).thenReturn(new UserDTO());

        ResponseEntity<UserDTO> response = userController.createUser(userDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(userService, times(1)).createUser(userDTO);
        verify(userService, times(1)).getUserById("userId");
    }

    @Test
    void testGetUserById() {
        String userId = "userId";
        when(userService.getUserById(userId)).thenReturn(new UserDTO());

        ResponseEntity<UserDTO> response = userController.getUserById(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void testGetUserByEmail() {
        String email = "test@example.com";
        when(userService.getUserByEmail(email)).thenReturn(new UserDTO());

        ResponseEntity<UserDTO> response = userController.getUserByEmail(email);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(userService, times(1)).getUserByEmail(email);
    }

    @Test
    void testGetAllUsers() {
        List<UserDTO> users = Collections.singletonList(new UserDTO());
        when(userService.getAllUsers()).thenReturn(users);

        ResponseEntity<List<UserDTO>> response = userController.getAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testUpdateUser() {
        String userId = "userId";
        UserDTO userDTO = new UserDTO();
        when(userService.updateUser(userId, userDTO)).thenReturn(new User());

        ResponseEntity<UserDTO> response = userController.updateUser(userId, userDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(userService, times(1)).updateUser(userId, userDTO);
        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void testDeleteUser() {
        String userId = "userId";

        ResponseEntity<Void> response = userController.deleteUser(userId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userService, times(1)).deleteUser(userId);
    }
}
