package com.user_service.app.repository;

import com.user_service.app.data.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testInsert(){
        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setPassword("abc");
        user.setPassword("john@email");

        userRepository.insert(user);

        Assertions.assertNotNull(user);
//        Assertions.assertNotEquals(,user.getId());

    }

}
