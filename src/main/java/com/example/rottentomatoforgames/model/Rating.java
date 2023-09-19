package com.example.rottentomatoforgames.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name= "ratings")
public class Rating {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "profile_id")
    private UserProfile ratedBy;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "game_id")
    private Game game;

    @Column
    private int rating;

    @Column
    private String review;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(UserProfile ratedBy) {
        this.ratedBy = ratedBy;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
