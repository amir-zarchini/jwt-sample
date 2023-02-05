package com.project.jwtsample.service;

import com.project.jwtsample.model.User;
import com.project.jwtsample.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registerNewUser(User user){
        return userRepository.save(user);
    }
}
