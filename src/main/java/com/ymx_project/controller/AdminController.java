package com.ymx_project.controller;

import com.ymx_project.entity.Admin;
import com.ymx_project.entity.User;
import com.ymx_project.entity.request.UserCreateRequest;
import com.ymx_project.repository.AdminRepository;
import com.ymx_project.service.AdminService;
import com.ymx_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("admin")
@CrossOrigin
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    private final AdminRepository adminRepository;

    @PostMapping
    void CreateAdmin(@RequestBody UserCreateRequest userCreateRequest){
        adminService.create(userCreateRequest);

    }


    @PostMapping("/login")
    String login(@RequestBody Admin admin){
        return "1111";
    }


}
