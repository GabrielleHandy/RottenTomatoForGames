package com.example.rottentomatoforgames.service;

import com.example.rottentomatoforgames.exception.InformationNotFoundException;
import com.example.rottentomatoforgames.model.User;
import com.example.rottentomatoforgames.model.UserProfile;
import com.example.rottentomatoforgames.repository.UserProfileRepository;
import com.example.rottentomatoforgames.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserProfileService {
    Logger logger = Logger.getLogger(UserProfileService.class.getName());
    private final UserProfileRepository userProfileRepository;
    private final UserService userService;
    private User user;
    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository, UserService userService) {
        this.userProfileRepository = userProfileRepository;
        this.userService = userService;

    }

    public void setUser() {
        if (user.getEmailAddress().equals(null)){
            MyUserDetails userDetails =(MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            this.user = userDetails.getUser();
        }

    }

    public UserProfile getMyProfile() {
        setUser();
        return userProfileRepository.findUserProfileByUser(user);
    }
}
