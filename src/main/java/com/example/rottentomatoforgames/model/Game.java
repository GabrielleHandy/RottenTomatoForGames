package com.example.rottentomatoforgames.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "games")
public class Game {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private int averageRating;


    @Column
    private List<Rating> ratings;

    @Column
    private List<Genres> genres;

    @Column
    private int releaseYear;

}


