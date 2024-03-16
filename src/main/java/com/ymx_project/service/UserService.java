package com.ymx_project.service;

import com.ymx_project.entity.User;
import com.ymx_project.request.UserCreateRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {


    User create(UserCreateRequest userCreateRequest);

    User readUserByUsername(String username);

    Optional<User> check(User user);
}
