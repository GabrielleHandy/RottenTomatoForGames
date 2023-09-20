package com.example.rottentomatoforgames.repository;

import com.example.rottentomatoforgames.model.Rating;
import com.example.rottentomatoforgames.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAllByGame_Id(Long gameId);
    boolean existsByRatedBy_IdAndGame_Id(Long ratedBy_id, Long game_id);
    Optional<Rating> findById(Long id);
    boolean existsByRatedByAndGame_Id(UserProfile userProfile, Long gameId);

    boolean existsByRatedByAndId(UserProfile userProfile, Long ratingId);
}
