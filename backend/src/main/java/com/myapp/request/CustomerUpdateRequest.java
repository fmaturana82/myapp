package com.myapp.request;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}
