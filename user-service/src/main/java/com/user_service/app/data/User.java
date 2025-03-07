package com.user_service.app.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String id;
    private String name;
    private String password;
    private String fullName;

}
