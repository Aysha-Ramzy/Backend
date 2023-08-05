package com.aysha.fullstackbackend.controller;

import java.util.List;
import com.aysha.fullstackbackend.model.User;
import com.aysha.fullstackbackend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
return userRepository.save(newUser);//post user
    }
    @GetMapping("/users")
    List<User> getAllUsers(){
return userRepository.findAll(); //get to frontend
    }

    @GetMapping("/user/{id}")
    void getUserById(@PathVariable Long id){
        //return
    }
}
