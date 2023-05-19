package com.myapp.request;

public record AuthenticationRequest(
        String username,
        String password
) {
}
