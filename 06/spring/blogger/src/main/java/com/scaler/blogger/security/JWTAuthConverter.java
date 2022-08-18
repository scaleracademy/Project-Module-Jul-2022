package com.scaler.blogger.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
class JWTAuthConverter implements AuthenticationConverter {

    @Override
    public JWTAuthentication convert(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            var authToken = authHeader.substring(7);
            return new JWTAuthentication(authToken);
        }

        return null;
    }
}
