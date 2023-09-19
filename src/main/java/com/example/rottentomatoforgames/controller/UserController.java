package com.example.rottentomatoforgames.controller;

import com.example.rottentomatoforgames.model.User;
import com.example.rottentomatoforgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/users")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/")
    public User createUser(@RequestBody User userObj){
        return userService.createUser(userObj);
    }
}
