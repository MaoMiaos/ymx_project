package com.ymx_project.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserIdRequest {
    @JsonProperty(value = "User_id")
    private String userId;
}
