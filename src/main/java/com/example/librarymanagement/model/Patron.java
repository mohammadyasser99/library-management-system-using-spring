package com.example.librarymanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patron {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int phoneNumber;
    private String contactInfo;

    public Patron(String name, String email, int phoneNumber , String contactInfo) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contactInfo = contactInfo;
    }
}
