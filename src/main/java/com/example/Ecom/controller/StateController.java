package com.example.Ecom.controller;

import com.example.Ecom.dto.CreateStateDto;
import com.example.Ecom.model.Country;
import com.example.Ecom.model.State;
import com.example.Ecom.repository.ICountryRepository;
import com.example.Ecom.repository.IStateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/state")
@RestController
public class StateController {
    private IStateRepository stateRepository;
    private ICountryRepository countryRepository;
    public StateController(IStateRepository stateRepository, ICountryRepository countryRepository) {
        this.stateRepository = stateRepository;
        this.countryRepository = countryRepository;
    }

    @PostMapping
    public ResponseEntity<String> CreateState(@RequestBody CreateStateDto state){

        Optional<Country> country= countryRepository.findById(state.CountryId);

        if(country.isEmpty())
        {
            return  ResponseEntity.badRequest().body("Country Not Found");
        }

        State newState = new State();
        newState.name=state.Name;
        newState.country=country.get();

        stateRepository.save(newState);

        return  ResponseEntity.ok("State created successfully!");
    }

    @GetMapping
    public List<State> GetAllStates(){
        return stateRepository.findAll();
    }
}
