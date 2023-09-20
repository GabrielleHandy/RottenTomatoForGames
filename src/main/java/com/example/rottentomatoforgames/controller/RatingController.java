package com.example.rottentomatoforgames.controller;

import com.example.rottentomatoforgames.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {
    RatingService ratingService;
    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }
}
