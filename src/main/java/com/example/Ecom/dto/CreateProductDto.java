package com.example.Ecom.dto;

import jakarta.validation.constraints.Email;

public class CreateProductDto {
    @Email(message = "Enter valid d")
    public  String name;
}
