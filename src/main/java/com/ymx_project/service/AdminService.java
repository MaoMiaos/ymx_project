package com.ymx_project.service;

import com.ymx_project.entity.Admin;
import com.ymx_project.entity.request.UserCreateRequest;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    Admin create(UserCreateRequest userCreateRequest);
}
