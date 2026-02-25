package com.example.Ecom.model;

import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    public  int id;

    @OneToOne
    @JoinColumn(name = "userId",insertable = false,updatable = false)
    public  User user;

    @Column(name = "userId")
    public  int userId;

    public  String profilePic;
    public  String socialMedia;
}
