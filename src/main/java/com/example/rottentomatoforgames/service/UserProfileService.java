package com.example.rottentomatoforgames.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    private final UserProfileService userProfileService;
    private final UserService userService;

    @Autowired
    public UserProfileService(UserProfileService userProfileService, UserService userService) {
        this.userProfileService = userProfileService;
        this.userService = userService;

    }


}
