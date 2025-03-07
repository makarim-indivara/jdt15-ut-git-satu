package com.user_service.app.data.dto;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String name;
    private String password;
    private String fullName;

}
