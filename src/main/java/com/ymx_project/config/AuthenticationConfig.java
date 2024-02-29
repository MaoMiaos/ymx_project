package com.ymx_project.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationConfig {
    public static final String SECRET = "Java_to_Dev_Secret";
    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Token";
    public static final String SIGN_UP_URL = "/api/user";

}
