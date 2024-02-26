package com.ymx_project.repository;

import com.ymx_project.entity.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;

    @Test
    void findDistinctById() {
        Admin admin = new Admin();
        admin.setId("111");
        admin.setUserName("123");
        admin.setPassword("1234");
        Admin saveadmin = adminRepository.save(admin);
        System.out.println(saveadmin.toString());
        adminRepository.findDistinctById("111");
    }
}