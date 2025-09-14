package com.julianne.pets.controllers;

import com.julianne.pets.entities.User;
import com.julianne.pets.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/createuser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        // put in service + error handling
        Optional<User> optionalUser = userRepository.findById(user.getUsername());
        if(optionalUser.isPresent()){
            return ResponseEntity.ok("Username already exists");
        }

        User userCreated = new  User();
        userCreated.setUsername(user.getUsername());
        userCreated.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userCreated);

        return ResponseEntity.badRequest().body("Successfully created user");
    }
}
