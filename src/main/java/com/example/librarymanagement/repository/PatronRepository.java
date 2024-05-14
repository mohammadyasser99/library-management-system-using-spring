package com.example.librarymanagement.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarymanagement.model.Patron;


public interface PatronRepository extends JpaRepository<Patron, Long>{
Optional<Patron> findByEmail(String email);
}
