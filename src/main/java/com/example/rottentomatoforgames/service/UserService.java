package com.example.rottentomatoforgames.service;
import com.example.rottentomatoforgames.exception.InformationExistException;
import com.example.rottentomatoforgames.model.User;
import com.example.rottentomatoforgames.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {
    Logger logger = Logger.getLogger(UserService.class.getName());
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(@Lazy PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    public User findUserByEmail(String email){
        return userRepository.findUserByEmailAddress(email);
    }
    public User createUser(User userObj){
        if(!userRepository.existsByEmailAddress(userObj.getEmailAddress())){
            userObj.setPassword(passwordEncoder.encode(userObj.getPassword()));
            return userRepository.save(userObj);
        }
        throw new InformationExistException("User with email address " + userObj.getEmailAddress()+ " already exists.");
    }
}
