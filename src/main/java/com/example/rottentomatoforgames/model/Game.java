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

    @OneToMany(mappedBy = "game", orphanRemoval = true)
    @Column
    private List<Rating> ratings;

    @Column
    private String genre;

    @Column
    private int releaseYear;

    public Game() {
    }

    public Game(Long id, String title, int averageRating, List<Rating> ratings, String genre, int releaseYear) {
        this.id = id;
        this.title = title;
        this.averageRating = averageRating;
        this.ratings = ratings;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}


