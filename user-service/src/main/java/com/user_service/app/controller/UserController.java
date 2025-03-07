package com.user_service.app.controller;

import com.user_service.app.data.User;
import com.user_service.app.data.dto.UserRequest;
import com.user_service.app.data.dto.UserResponse;
import com.user_service.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    @Autowired
    private UserService userService;

    public User register(String name, String password, String fullName){
        return userService.register(name, password, fullName);
    }

    public User get(String id){
        return userService.get(id);
    }
}
