package com.example.rottentomatoforgames.service;
import com.example.rottentomatoforgames.exception.InformationExistException;
import com.example.rottentomatoforgames.model.User;
import com.example.rottentomatoforgames.model.UserProfile;
import com.example.rottentomatoforgames.model.request.LoginRequest;
import com.example.rottentomatoforgames.repository.UserProfileRepository;
import com.example.rottentomatoforgames.repository.UserRepository;
import com.example.rottentomatoforgames.security.JwtUtils;
import com.example.rottentomatoforgames.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {
    Logger logger = Logger.getLogger(UserService.class.getName());
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final AuthenticationManager authenticationManager;
    private final UserProfileService userProfileService;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserService(@Lazy PasswordEncoder passwordEncoder, UserRepository userRepository, UserProfileRepository userProfileRepository, @Lazy AuthenticationManager authenticationManager, @Lazy  UserProfileService userProfileService, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.authenticationManager = authenticationManager;
        this.userProfileService = userProfileService;
        this.jwtUtils = jwtUtils;

    }
    public User findUserByEmail(String email){
        return userRepository.findUserByEmailAddress(email);
    }
    public User createUser(User userObj){
        if(!userRepository.existsByEmailAddress(userObj.getEmailAddress())){
            userObj.setPassword(passwordEncoder.encode(userObj.getPassword()));
            userObj.setUserProfile(userProfileService.createUserProfile(userObj));
            return userRepository.save(userObj);

        }
        throw new InformationExistException("User with email address " + userObj.getEmailAddress()+ " already exists.");
    }

    /**
     * Logins in user and return JWT Token and updates when Last active on their profile
     * @param loginRequest
     * Object holding login email and password
     * @return
     * returns Jwt Token
     */
    public Optional<String> loginUser(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmailAddress(), loginRequest.getPassword());
        try{
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            MyUserDetails myUserDetails =  (MyUserDetails) authentication.getPrincipal();
            UserProfile userProfile = myUserDetails.getUser().getUserProfile();
            userProfile.setLastActive(new Date());
            userProfileRepository.save(userProfile);
            return Optional.of(jwtUtils.generateJwtToken(myUserDetails));
        }catch (Exception e){
            return Optional.empty();
        }


    }
}
