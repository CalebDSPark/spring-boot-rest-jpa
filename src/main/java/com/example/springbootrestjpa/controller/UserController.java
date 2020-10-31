package com.example.springbootrestjpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springbootrestjpa.exception.ResourceNotFoundException;
import com.example.springbootrestjpa.model.User;
import com.example.springbootrestjpa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
      return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
      User user = userRepository
              .findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("User", id));
      return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {                    
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id,
                           @Valid @RequestBody User userDetails) {

        User user = userRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User", id));

        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());            
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);              
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id) {
    User user = userRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User", id));

    userRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
  
}
