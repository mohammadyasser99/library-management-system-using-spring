package com.example.librarymanagement.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarymanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

   List<User> findByEmail(String email);
    
} 
