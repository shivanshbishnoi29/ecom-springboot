package com.example.Ecom.controller;

import com.example.Ecom.model.User;
import com.example.Ecom.repository.IUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private IUserRepository userRepository;

    public   UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public  void  AddUser(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
