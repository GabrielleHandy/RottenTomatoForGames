package com.example.rottentomatoforgames.service;

import com.example.rottentomatoforgames.exception.InformationNotFoundException;
import com.example.rottentomatoforgames.model.Game;
import com.example.rottentomatoforgames.model.Rating;
import com.example.rottentomatoforgames.repository.GameRepository;
import com.example.rottentomatoforgames.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final GameRepository gameRepository;
    @Autowired
    public RatingService(RatingRepository ratingRepository, GameRepository gameRepository) {
        this.ratingRepository = ratingRepository;
        this.gameRepository = gameRepository;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<Rating> findRatingsByGame(Long gameId) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if(optionalGame.isPresent()){
            return optionalGame.get().getRatings();
        }
        throw new InformationNotFoundException("Game with Id: " + gameId + " not found in database");
    }
}
