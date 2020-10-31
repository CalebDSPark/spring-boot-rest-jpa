package com.example.springbootrestjpa.controller;

import java.util.List;

import com.example.springbootrestjpa.exception.ResourceNotFoundException;
import com.example.springbootrestjpa.model.User;
import com.example.springbootrestjpa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepo;
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
      return userRepo.findAll();
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
      User user = userRepo
              .findById(userId)
              .orElseThrow(() -> new ResourceNotFoundException("User not found on :: ", userId));
      return ResponseEntity.ok().body(user);
    }
  
}
