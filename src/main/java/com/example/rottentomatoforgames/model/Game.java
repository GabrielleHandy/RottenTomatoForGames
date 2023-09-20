package com.example.rottentomatoforgames.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Rating> ratings;

    @Column
    private int releaseYear;

    public Game() {
    }

    public Game(Long id, String title, int averageRating, List<Rating> ratings,  int releaseYear) {
        this.id = id;
        this.title = title;
        this.averageRating = averageRating;
        this.ratings = ratings;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAverageRating() {
        return averageRating;
    }

    /**
     * Calculates new averages after a change in Ratings happens
     * and checks for 0 ratings to avoid / by zero error
     */
    public void setAverageRating() {
        if(ratings.isEmpty()){
            this.averageRating = 0;
            return;

        }
        int sumRating = 0;

        for (Rating rating : ratings) {
            sumRating += rating.getRating();
        }

        this.averageRating = sumRating/ratings.size();

    }

    public List<Rating> getRatings() {
        return ratings;
    }





    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", averageRating=" + averageRating +
                ", ratings=" + ratings + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}


