package com.example.rottentomatoforgames.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column(unique = true)
    private String emailAddress;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    private String password;



}
