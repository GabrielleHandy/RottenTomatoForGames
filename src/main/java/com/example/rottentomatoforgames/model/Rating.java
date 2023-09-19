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
    private User ratedBy;

    @ManyToOne
    @JsonIgnore
    private Game game;

    @Column
    private int rating;

    @Column
    private String review;
}
