package com.example.Ecom.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name="products_table")
public class Product {

    @Id
    @GeneratedValue
    public int id;

    public  String name;

    @Column(columnDefinition = "TINYINT(1) default 1")
    public Boolean isActive;
}
