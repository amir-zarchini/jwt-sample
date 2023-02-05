package com.project.jwtsample.service;

import com.project.jwtsample.model.Role;
import com.project.jwtsample.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role createNawRole(Role role) {
        return roleRepository.save(role);
    }
}
