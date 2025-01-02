package com.xebia.studentevaluationapp.util;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 1L;
	private final Object principal; // Usually the user details (e.g., username or User object)
    private String token;

    public JwtAuthenticationToken(Object principal, String token) {
        super(null);
        this.principal = principal;
        this.token = token;
        setAuthenticated(false); // Mark as unauthenticated initially
    }

    public JwtAuthenticationToken(User principal, String token, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.token = token;
        setAuthenticated(true); // Mark as authenticated
    }

    @Override
    public Object getCredentials() {
        return token; // Return the JWT token as credentials
    }

    @Override
    public Object getPrincipal() {
        return principal; // Return the user details or username
    }
}

