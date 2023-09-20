package com.example.rottentomatoforgames.repository;

import com.example.rottentomatoforgames.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    /**
     * Finds the highest rated game
     * @return
     * returns Game with the highest rating
     */
    Game findTopByOrderByAverageRatingDesc();

}
