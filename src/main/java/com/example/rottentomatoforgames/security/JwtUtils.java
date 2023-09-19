package com.example.rottentomatoforgames.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class JwtUtils {
    Logger logger = Logger.getLogger(JwtUtils.class.getName());

    @Value("${jwt-secret}")
    private String jwtSecret;

    @Value("${jwt-expiration-ms}")
    private String jwtExpMs;


}
