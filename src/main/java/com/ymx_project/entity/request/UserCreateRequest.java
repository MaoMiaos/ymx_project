package com.ymx_project.entity.request;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String username;
    private String password;
    private String name;
}
