package com.example.rottentomatoforgames.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="profiles")
public class UserProfile {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "userProfile")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "ratedBy", orphanRemoval = true)
    private List<Rating>  ratings;
//    List<Follower>

    @Column
    private Date lastActive;


    public UserProfile() {
        setLastActive();
    }

    public UserProfile(Long id, User user, Date lastActive) {
        this.id = id;
        this.user = user;
        this.lastActive = lastActive;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLastActive() {
        this.lastActive = new Date();
    }


}
