package com.prismaplaza.shopping.controller;

import com.prismaplaza.shopping.entity.User;
import com.prismaplaza.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userToUpdate) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));

        existingUser.setEmail(userToUpdate.getEmail());
        existingUser.setPassword(userToUpdate.getPassword());

        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User userToDelete = userRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));

        userRepository.delete(userToDelete);

        return ResponseEntity.ok().build();
    }

}
