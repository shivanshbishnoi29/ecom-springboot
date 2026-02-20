package com.example.Ecom.controller;

import com.example.Ecom.dto.CreateCountryDto;
import com.example.Ecom.model.Country;
import com.example.Ecom.repository.ICountryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/country")
@RestController
public class CountryController {
    private ICountryRepository  countryRepository;
    public CountryController(ICountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PostMapping
    public  void  CreateCountry(@RequestBody CreateCountryDto country)
    {
        Country newCountry = new Country();
        newCountry.name=country.Name;

        countryRepository.save(newCountry);
    }

    @GetMapping
    public List<Country> getAllCountry()
    {
        return countryRepository.findAll();
    }
}
