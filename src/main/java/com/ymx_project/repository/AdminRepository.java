package com.ymx_project.repository;

import com.ymx_project.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 使用JpaRepository
 * 你可以在不编写任何实现代码的情况下
 * 实现对数据库的基本操作
 * Spring Data JPA会根据接口中定义的方法名自动生成实现代码
 * 这种约定优于配置的方式，大大简化了数据访问层的开发
 */
public interface AdminRepository extends JpaRepository<Admin,String> {

    List<Admin> findDistinctById(String id);
}
