package com.example.Ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    public  int Id;

   public  String Name;
   public  String Password;
   public  String Email;
}
