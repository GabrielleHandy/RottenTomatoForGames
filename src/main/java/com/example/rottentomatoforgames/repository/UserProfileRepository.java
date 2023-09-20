package com.example.rottentomatoforgames.repository;

import com.example.rottentomatoforgames.model.User;
import com.example.rottentomatoforgames.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findUserProfileByUserId(Long userId);
}
