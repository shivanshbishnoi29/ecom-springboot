package com.example.Ecom.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;

@Entity
public class State {
    @Id
    @GeneratedValue
    public  int id;

    public String name;

    @ManyToOne
    @JoinColumn(name = "countryId")
    @JsonIgnoreProperties("states")
    public  Country country;
}
