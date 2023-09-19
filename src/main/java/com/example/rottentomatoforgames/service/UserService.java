package com.example.rottentomatoforgames.service;
import com.example.rottentomatoforgames.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {
    Logger logger = Logger.getLogger(UserService.class.getName());
    private PasswordEncoder passwordEncoder;




}
