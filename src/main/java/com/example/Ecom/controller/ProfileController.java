package com.example.Ecom.controller;

import com.example.Ecom.dto.CreateProfileDto;
import com.example.Ecom.model.Profile;
import com.example.Ecom.model.User;
import com.example.Ecom.repository.IProfileRepsitory;
import com.example.Ecom.repository.IUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/profile")
public class ProfileController {
    private IProfileRepsitory profileRepsitory;
    private  IUserRepository userRepository;
    public ProfileController(IProfileRepsitory profileRepsitory, IUserRepository userRepository) {
        this.profileRepsitory = profileRepsitory;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<String> AddProfile(@RequestBody CreateProfileDto profile){

//        Optional<User> user=userRepository.findById(profile.userId);
//        if(user.isEmpty()){
//          return ResponseEntity.badRequest().body("User not found");
//        }
        Profile newProfile=new Profile();
        newProfile.userId=profile.userId;
        newProfile.profilePic=profile.profilePic;
        newProfile.socialMedia=profile.socialMedia;
        newProfile.id=profile.id;

        profileRepsitory.save(newProfile);

        return  ResponseEntity.ok("Profile added");
    }

    @GetMapping
    public List<Profile> findAll(){
        return profileRepsitory.findAll();
    }
}
