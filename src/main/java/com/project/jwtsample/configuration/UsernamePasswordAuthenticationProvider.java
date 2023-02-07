package com.project.jwtsample.configuration;

import com.project.jwtsample.service.UserDetailServiceDao;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailServiceDao userDetailServiceDao;

    private  PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        SecurityUser securityUser = (SecurityUser) userDetailServiceDao.loadUserByUsername(username);
        if (passwordEncoder.matches(password, securityUser.getPassword())){
            return authentication;
        }
        throw new BadCredentialsException("password is not valid!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
