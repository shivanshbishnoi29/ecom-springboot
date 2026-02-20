package com.example.Ecom.repository;

import com.example.Ecom.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country,Integer> {
}
