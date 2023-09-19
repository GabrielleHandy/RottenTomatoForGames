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
}
