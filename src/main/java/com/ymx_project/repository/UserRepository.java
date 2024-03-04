package com.ymx_project.repository;

import com.ymx_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT DISTINCT name FROM user WHERE id = :userid",nativeQuery = true)
    String findUsernameById(@Param("userid") String userid);
}
