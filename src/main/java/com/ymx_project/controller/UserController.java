package com.ymx_project.controller;

import com.ymx_project.entity.User;
import com.ymx_project.request.UserCreateRequest;
import com.ymx_project.repository.AdminRepository;
import com.ymx_project.repository.UserRepository;
import com.ymx_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    private final AdminRepository adminRepository;

    @PostMapping("/create")
    ResponseEntity create(HttpServletRequest request, @RequestBody UserCreateRequest userCreateRequest){
//        String token = request.getHeader("token");
        userService.create(userCreateRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    User login(@RequestBody User user){
        Optional<User> user1 = userService.check(user);
        user1.get().setPassword("canNotSee");
        return user1.orElse(user);
    }


}
