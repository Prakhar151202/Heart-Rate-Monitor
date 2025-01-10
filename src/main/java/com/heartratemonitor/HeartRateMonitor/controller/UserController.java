package com.heartratemonitor.HeartRateMonitor.controller;


import com.heartratemonitor.HeartRateMonitor.model.Users;
import com.heartratemonitor.HeartRateMonitor.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registerUser")
    public ResponseEntity<String> addUser(@Valid @RequestBody Users user) {
        // Validation check for unique email
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }

        // Add the user to the database
        userRepository.save(user);
        return new ResponseEntity<>("New User Added Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Users loginRequest) {
        // Check for existence of user
        Optional<Users> optionalUser = userRepository.findByEmail(loginRequest.getEmail());
        if (!optionalUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        // Password Validation
        Users user = optionalUser.get();
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        return ResponseEntity.ok("Login successful");
    }
}

