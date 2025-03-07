package com.user_service.app.controller;

import com.user_service.app.data.User;
import com.user_service.app.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegister() {
        User mockUser = new User("1", "testUser", "password123", "Test User");
        when(userService.register("testUser", "password123", "Test User")).thenReturn(mockUser);

        User result = userController.register("testUser", "password123", "Test User");

        assertNotNull(result);
        assertEquals("testUser", result.getName());
        assertEquals("Test User", result.getFullName());
    }

    @Test
    void testGet() {
        User mockUser = new User("1", "testUser", "password123", "Test User");
        when(userService.get("1")).thenReturn(mockUser);

        User result = userController.get("1");

        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("testUser", result.getName());
    }

}
