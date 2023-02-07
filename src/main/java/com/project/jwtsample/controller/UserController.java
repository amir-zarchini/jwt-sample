package com.project.jwtsample.controller;

import com.project.jwtsample.model.User;
import com.project.jwtsample.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostConstruct
//    public void initRoleAndUser() {
//        userService.initRoleAndUser();
//    }

    @PostMapping(path = "/registerNewUser")
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping(path = "/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin() {
        return "only access for admin";
    }

    @GetMapping(path = "/forUser")
    @PreAuthorize("hasRole('User')")
    public String forUser() {
        return "only access for user";
    }
}
