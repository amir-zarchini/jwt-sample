package com.project.jwtsample.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationNotSupportedException;

@Component
@RequiredArgsConstructor
public class AuthenticationManagerConfiguration  implements AuthenticationManager {

    private final UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            if (usernamePasswordAuthenticationProvider.supports(UsernamePasswordAuthenticationToken.class)){
                return usernamePasswordAuthenticationProvider.authenticate(authentication);
            }
            throw new AuthenticationNotSupportedException("not supported method");
        } catch (AuthenticationNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
