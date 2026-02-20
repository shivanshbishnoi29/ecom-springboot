package com.example.Ecom.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Entity
public class Country {
    @Id
    @GeneratedValue
    public  int id;

    public  String name;

    @OneToMany(mappedBy = "country")
    public List<State> states;
}
