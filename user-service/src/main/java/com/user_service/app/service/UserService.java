package com.user_service.app.service;

import com.user_service.app.data.User;
import com.user_service.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User register(String name, String password, String fullName) {
        User user = new User(UUID.randomUUID().toString(), name, password, fullName);
        userRepository.insert(user);
        return user;
    }

    public User get(String id) {
        User user = userRepository.findbyId(id);
        if(user == null){
            throw new IllegalArgumentException("Tidak Ada User");
        } else {
            System.out.println(user);
            return user;
        }
    }

}
