package com.user_service.app.repository;

import org.springframework.stereotype.Repository;
import com.user_service.app.data.User;

@Repository
public interface UserRepository {

    void insert (User user);
    User findbyId (String id);
}
