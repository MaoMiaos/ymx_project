package com.ymx_project.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;

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
