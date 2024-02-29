package com.ymx_project.service;

import com.ymx_project.entity.User;
import com.ymx_project.entity.request.UserCreateRequest;
import com.ymx_project.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    User create(UserCreateRequest userCreateRequest);

    User readUserByUsername(String username);

}
