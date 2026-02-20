package com.example.Ecom.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class State {
    @Id
    @GeneratedValue
    public  int id;

    public String name;

    @ManyToOne
    @JoinColumn(name = "countryId")
    @JsonBackReference
    public  Country country;
}
