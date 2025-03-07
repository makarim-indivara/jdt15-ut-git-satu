package com.user_service.app.service;


import com.user_service.app.data.User;
import com.user_service.app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Test
    void testRegisterUser() {

        UserRepository mockRepo = mock(UserRepository.class);
        UserService userService = new UserService(mockRepo);
        User user = new User(UUID.randomUUID().toString(), "john_doe", "password123", "John Doe");
        User registeredUser = userService.register("john_doe", "password123", "John Doe");
        verify(mockRepo).insert(registeredUser);
        assertEquals("john_doe", registeredUser.getName());
        assertEquals("John Doe", registeredUser.getFullName());
    }

    @Test
    void testGetUser() {

        UserRepository mockRepo = mock(UserRepository.class);
        UserService userService = new UserService(mockRepo);
        User mockUser = new User(UUID.randomUUID().toString(), "jane_doe", "password456", "Jane Doe");
        System.out.println(mockUser.getId());
        when(mockRepo.findbyId(mockUser.getId())).thenReturn(mockUser);
        User retrievedUser = userService.get(mockUser.getId());
        verify(mockRepo).findbyId(mockUser.getId());
        assertNotNull(retrievedUser);
        assertEquals("jane_doe", retrievedUser.getName());
        assertEquals("Jane Doe", retrievedUser.getFullName());
    }

    @Test
    void testGetUser_NotFound() {
        UserRepository mockRepo = mock(UserRepository.class);
        UserService userService = new UserService(mockRepo);
        when(mockRepo.findbyId("999")).thenReturn(null);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.get("999");
        });
        assertEquals("Tidak Ada User", exception.getMessage());
    }

    @Test
    void testRegisterSuccess(){
        UserRepository mockRepo = mock(UserRepository.class);
        UserService userService = new UserService(mockRepo);
        User user  = userService.register("jane_doe", "password456", "Jane Doe");
        Assertions.assertNotNull(user);
        Assertions.assertEquals("jane_doe", user.getName());
        Assertions.assertNotNull(user.getId());
        verify(mockRepo, Mockito.times(1)).insert(new User(user.getId(), "jane_doe","password456", "Jane Doe"));
    }

}
