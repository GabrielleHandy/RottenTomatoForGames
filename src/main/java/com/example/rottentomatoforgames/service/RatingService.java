package com.example.rottentomatoforgames.service;

import com.example.rottentomatoforgames.exception.InformationExistException;
import com.example.rottentomatoforgames.exception.InformationNotFoundException;
import com.example.rottentomatoforgames.model.Game;
import com.example.rottentomatoforgames.model.Rating;
import com.example.rottentomatoforgames.model.User;
import com.example.rottentomatoforgames.model.request.AddRatingRequest;
import com.example.rottentomatoforgames.repository.GameRepository;
import com.example.rottentomatoforgames.repository.RatingRepository;
import com.example.rottentomatoforgames.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final GameRepository gameRepository;
    private User user;
    @Autowired
    public RatingService(RatingRepository ratingRepository, GameRepository gameRepository) {
        this.ratingRepository = ratingRepository;
        this.gameRepository = gameRepository;
    }
    public void setUser() {

        MyUserDetails userDetails =(MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.user = userDetails.getUser();

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

    public Rating addRating(Rating newRating, Long gameId) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if(optionalGame.isPresent()){
            setUser();
            if(!ratingRepository.existsByRatedBy_IdAndGame_Id(user.getUserProfile().getId(), gameId)){
                newRating.setRatedBy(user.getUserProfile());
                newRating.setGame(optionalGame.get());
                ratingRepository.save(newRating);
            }
            throw new InformationExistException("You already made a rating for this game");
        }
        throw new InformationNotFoundException("Game with Id: " + gameId + " not found in database");

    }
}
