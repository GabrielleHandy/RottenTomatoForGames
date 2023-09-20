package com.example.rottentomatoforgames.service;

import com.example.rottentomatoforgames.exception.InformationNotFoundException;
import com.example.rottentomatoforgames.model.User;
import com.example.rottentomatoforgames.model.UserProfile;
import com.example.rottentomatoforgames.repository.UserProfileRepository;
import com.example.rottentomatoforgames.repository.UserRepository;
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
    private final UserRepository userRepository;
    private User user;
    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository, UserRepository userRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;


    }

    public void setUser() {
        if (user == null){
            MyUserDetails userDetails =(MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            this.user = userDetails.getUser();
        }

    }
    public UserProfile createUserProfile(User newUser){
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(newUser);
        return userProfile;

    }

    public UserProfile getMyProfile() {
        setUser();

        return userProfileRepository.findUserProfileByUserId(user.getId());
    }


    public UserProfile findUserProfileByUserId(Long Id) {
        Optional<User> optionalUser = userRepository.findById(Id);
        if (optionalUser.isPresent()) {
            return userProfileRepository.findUserProfileByUserId(optionalUser.get().getId());
        }
        throw new InformationNotFoundException("User with Id: " + Id + " doesn't exist.");
    }
}