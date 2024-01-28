package com.aysha.fullstackbackend.controller;

import java.util.List;
import java.util.Optional;

import com.aysha.fullstackbackend.model.User;
import com.aysha.fullstackbackend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PutMapping("/user/{id}")
    User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(updatedUser.getName());
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        }
        throw new IllegalArgumentException("User not found with id: " + id);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}