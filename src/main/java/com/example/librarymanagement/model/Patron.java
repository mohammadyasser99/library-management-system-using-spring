package com.example.librarymanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
    private int phoneNumber;
    private String contactInfo;

    @Email(message = "Please provide a valid email")
    private String email;
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private String role;

    public Patron(String name, int phoneNumber, String contactInfo, String email, String password, String role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.contactInfo = contactInfo;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
