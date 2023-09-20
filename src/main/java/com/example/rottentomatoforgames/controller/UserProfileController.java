package com.example.rottentomatoforgames.controller;

import com.example.rottentomatoforgames.model.UserProfile;
import com.example.rottentomatoforgames.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
public class UserProfileController {
    UserProfileService userProfileService;
    @Autowired
    public void setUserProfileService(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/myprofile/")
    public UserProfile getMyProfile(){
        return userProfileService.getMyProfile();
    }

    @GetMapping("/${profileId}}")
    public UserProfile getUserProfile(@PathVariable(value = "profileId") Long id){
        return userProfileService.getUserProfile(id);
    }
}
