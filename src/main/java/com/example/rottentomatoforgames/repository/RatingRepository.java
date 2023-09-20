package com.example.rottentomatoforgames.repository;

import com.example.rottentomatoforgames.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAllByGame_Id(Long gameId);
    Rating findByRatedBy_IdAndGame_Id(Long ratedBy_id, Long game_id);

}
