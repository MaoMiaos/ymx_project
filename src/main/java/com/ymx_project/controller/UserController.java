package com.ymx_project.controller;

import com.ymx_project.entity.User;
import com.ymx_project.entity.request.UserCreateRequest;
import com.ymx_project.repository.UserRepository;
import com.ymx_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    @PostMapping("/create")
    ResponseEntity create(@RequestBody UserCreateRequest userCreateRequest){
        userService.create(userCreateRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    User login(@Validated @RequestBody User user){
        Optional<User> user1 = userRepository.findByUsername(user.getUsername());
        user1.get().setPassword("canNotSee");
        return user1.orElse(user);

    }


}
