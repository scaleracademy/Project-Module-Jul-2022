package com.scaler.blogger.security;

import com.scaler.blogger.users.UserDTO;
import com.scaler.blogger.users.UserEntity;
import com.scaler.blogger.users.UserJwtService;
import com.scaler.blogger.users.UsersService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class JWTAuthManager implements AuthenticationManager {
    private UserJwtService userJwtService;
    private UsersService usersService;

    public JWTAuthManager(UserJwtService userJwtService, UsersService usersService) {
        this.userJwtService = userJwtService;
        this.usersService = usersService;
    }

    @Override
    public JWTAuthentication authenticate(Authentication authentication) throws AuthenticationException {

        if (!(authentication instanceof JWTAuthentication jwtAuthentication)) {
            throw new IllegalArgumentException("Authentication is not supported");
        }

        String token = jwtAuthentication.getCredentials();
        String username = userJwtService.getUsernameFromJwtToken(token);
        UserEntity user = usersService.getUserEntityByUsername(username);

        jwtAuthentication.setUserEntity(user);

        return jwtAuthentication;
    }
}
