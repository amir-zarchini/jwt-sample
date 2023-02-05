package com.project.jwtsample.controller;

import com.project.jwtsample.model.Role;
import com.project.jwtsample.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping(path = "/createNewRole")
    public Role createNawRole(@RequestBody Role role) {
        return roleService.createNawRole(role);
    }
}
