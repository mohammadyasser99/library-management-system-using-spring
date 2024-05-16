package com.example.librarymanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.model.User;
import com.example.librarymanagement.repository.UserRepository;
import com.example.librarymanagement.request.LoginRequest;
import com.example.librarymanagement.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
   



    //adding user
    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user,
     BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation failed: " 
            + bindingResult.getFieldError().getDefaultMessage());
        }
      return ResponseEntity.ok(userService.addUser(user));
    }

    @RequestMapping("/login")
    public User login(Authentication authentication) {
        List<User> users = userRepository.findByEmail(authentication.getName());
        if(users.size() > 0) {
            return users.get(0);
        }else {
            return null;
        }
    }

}
