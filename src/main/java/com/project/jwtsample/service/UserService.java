package com.project.jwtsample.service;

import com.project.jwtsample.model.Role;
import com.project.jwtsample.model.User;
import com.project.jwtsample.repository.RoleRepository;
import com.project.jwtsample.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

        User adminUser = new User();
        adminUser.setUsername("admin123");
        adminUser.setPassword(passwordEncoder.encode("adminpass"));
        adminUser.setFullName("admin admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setUserRole(adminRoles);
        userRepository.save(adminUser);

        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("userpass"));
        user.setFullName("user user");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setUserRole(userRoles);
        userRepository.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleRepository.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setUserRole(userRoles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
