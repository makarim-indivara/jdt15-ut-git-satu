package com.user_service.app.data;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String password;
    private String fullName;

}
