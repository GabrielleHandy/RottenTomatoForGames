package com.example.rottentomatoforgames.controller;

import com.example.rottentomatoforgames.model.Rating;
import com.example.rottentomatoforgames.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    RatingService ratingService;
    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/")
    public List<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }

    @GetMapping("/Game/{gameId}")
    public List<Rating> getAllRatingsByGame(@PathVariable(value = "gameId")Long gameId) {
        return ratingService.findRatingsByGame(gameId);
    }
}
