package com.example.librarymanagement.model;







import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Author is required")
    private String author;
    @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters")
    private String isbn;
    @NotBlank(message = "Publisher is required")
    private String publisher;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date publishedDate;

    @Lob
    @JsonIgnore
    private Blob photo;

    // Additional field for Base64 encoded image
    @Transient
    private String photoBase64;

    @PostLoad
    private void postLoad() {
        this.photoBase64 = encodeImageToBase64(this.photo);
    }

    public Book(String title, String author, String isbn, String publisher, Date publishedDate, Blob imageData) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.photo = imageData;
        this.photoBase64 = encodeImageToBase64(imageData);
    }

    private String encodeImageToBase64(Blob blob) {
        if (blob != null) {
            try {
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                return Base64.getEncoder().encodeToString(imageBytes);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
