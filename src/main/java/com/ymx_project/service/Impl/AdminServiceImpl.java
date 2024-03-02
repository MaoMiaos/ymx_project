package com.ymx_project.service.Impl;

import com.ymx_project.entity.Admin;
import com.ymx_project.entity.User;
import com.ymx_project.entity.request.UserCreateRequest;
import com.ymx_project.repository.AdminRepository;
import com.ymx_project.service.AdminService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public Admin create(UserCreateRequest userCreateRequest) {
        Admin admin = new Admin();
        Optional<Admin> byUsername = adminRepository.findByUsername(userCreateRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        admin.setUsername(userCreateRequest.getUsername());
        admin.setPassword(userCreateRequest.getPassword());
//        admin.setPassword(bCryptPasswordEncoder.encode(userCreateRequest.getPassword()));
        return adminRepository.save(admin);
    }

}
