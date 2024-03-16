package com.ymx_project.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserCreateRequest {

    @JsonProperty(value = "username")
    private String username;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "role")
    private String role;
}
