package com.user_service.app.controller;

import com.user_service.app.data.dto.UserRequest;
import com.user_service.app.data.dto.UserResponse;
import com.user_service.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    @Autowired
    private UserService userService;

    public UserResponse postUser(UserRequest request){
        return null;
    }

    public UserResponse getUser(UserRequest request){
        return null;
    }
}
