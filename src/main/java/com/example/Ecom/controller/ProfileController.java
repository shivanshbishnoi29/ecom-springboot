package com.example.Ecom.controller;

import com.example.Ecom.dto.CreateProfileDto;
import com.example.Ecom.model.Profile;
import com.example.Ecom.model.User;
import com.example.Ecom.repository.IProfileRepsitory;
import com.example.Ecom.repository.IUserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/profile")
public class ProfileController {
    private IProfileRepsitory profileRepsitory;
    private  IUserRepository userRepository;
    private MailSender mailSender;
    public  ProfileController (MailSender mailSender) {
        this.mailSender = mailSender;
    }
    public ProfileController(IProfileRepsitory profileRepsitory, IUserRepository userRepository, MailSender mailSender) {
        this.profileRepsitory = profileRepsitory;
        this.userRepository = userRepository;
        this.mailSender = mailSender;
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

    @PostMapping("sendmail")
    public  String  SendMail(@RequestParam String email, @RequestParam String subject, @RequestParam String body)
    {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("shivanshbisnoi@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);

        mailSender.send(mailMessage);
        return  "Email send successfully";
    }
}
