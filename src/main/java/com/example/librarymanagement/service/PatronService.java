package com.example.librarymanagement.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.exception.AllReadyExists;
import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.model.Patron;
import com.example.librarymanagement.repository.PatronRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatronService {

 private final PatronRepository patronRepository;
    private final PasswordEncoder passwordEncoder;
    public void addPatron(Patron patron) {
    if (patronRepository.findByEmail(patron.getEmail()).size() > 0) {
            System.out.println("Patron already exists");
            throw new AllReadyExists("Patron already exists");
        } else {
            patron.setPassword(passwordEncoder.encode(patron.getPassword()));
            patronRepository.save(patron);
            System.out.println("Patron added successfully");
        }
    }

    public List<Patron> getPatrons() {
        if (patronRepository.findAll().isEmpty()) {
            System.out.println("No patrons found");
            throw new ResourceNotFoundException("No patrons found");
        } else {   
            return patronRepository.findAll();
        }
     
    }

    public void updatePatron(Long id, Patron patron) {
        Patron existingPatron = patronRepository.findById(id).orElse(null);
        if (existingPatron != null) {
            existingPatron.setName(patron.getName());
            existingPatron.setEmail(patron.getEmail());
            existingPatron.setPhoneNumber(patron.getPhoneNumber());
            existingPatron.setContactInfo(patron.getContactInfo());
            patronRepository.save(existingPatron);
        } else {
            System.out.println("Patron not found");
            throw new ResourceNotFoundException("Patron not found");
        }
    }

    public Patron getPatron(Long id) {
      
        Patron patron = patronRepository.findById(id).orElse(null);
        if (patron == null) {
            System.out.println("Patron not found");
            throw new ResourceNotFoundException("Patron not found");
        } else {
            return patron;
        }
    }

    public void deletePatron(Long id) {
       
       if (patronRepository.findById(id).isPresent()) {
            patronRepository.deleteById(id);
            System.out.println("Patron deleted successfully");
        } else {
            System.out.println("Patron not found");
            throw new ResourceNotFoundException("Patron not found");
        }
    }
    

}
