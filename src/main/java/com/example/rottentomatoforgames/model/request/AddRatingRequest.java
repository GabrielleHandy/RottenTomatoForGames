package com.example.rottentomatoforgames.model.request;

import javax.persistence.Column;

public class AddRatingRequest {

    private int rating;


    private String review;

    public AddRatingRequest() {
    }

    public AddRatingRequest(int rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
}
