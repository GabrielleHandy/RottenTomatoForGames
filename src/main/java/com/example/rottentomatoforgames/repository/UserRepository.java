package com.example.rottentomatoforgames.repository;

import com.example.rottentomatoforgames.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmailAddress(String emailAddress);
}
