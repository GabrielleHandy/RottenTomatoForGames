package com.example.rottentomatoforgames.controller;

import com.example.rottentomatoforgames.model.Rating;
import com.example.rottentomatoforgames.model.request.AddRatingRequest;
import com.example.rottentomatoforgames.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/game/{gameId}")
    public List<Rating> getAllRatingsByGame(@PathVariable(value = "gameId")Long gameId) {
        return ratingService.findRatingsByGame(gameId);
    }

    @PostMapping("/addRating/{gameId}")
    public Rating addRating(@RequestBody Rating ratingObj, @PathVariable(value = "gameId")Long gameId){
        return ratingService.addRating(ratingObj, gameId);
    }

}
