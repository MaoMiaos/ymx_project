package com.ymx_project.service.Impl;

import com.ymx_project.entity.User;
import com.ymx_project.request.UserCreateRequest;
import com.ymx_project.repository.UserRepository;
import com.ymx_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User readUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Optional<User> check(User user) {
        Optional<User> user1 = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        return user1;
    }

    @Override
    public User create(UserCreateRequest userCreateRequest){
        User user = new User();
        Optional<User> byUsername = userRepository.findByUsername(userCreateRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        user.setUsername(userCreateRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userCreateRequest.getPassword()));
//        user.setPassword(userCreateRequest.getPassword());
        user.setRole(userCreateRequest.getRole());
        user.setName(userCreateRequest.getName());
        return userRepository.save(user);
    }
}
