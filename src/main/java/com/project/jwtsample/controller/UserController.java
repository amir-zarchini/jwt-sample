package com.project.jwtsample.controller;

import com.project.jwtsample.model.User;
import com.project.jwtsample.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/registerNewUser")
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }
}
