package com.example.librarymanagement.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddBookRequest {
@NotBlank
private String title;
@NotBlank
private String author;
@NotBlank
private String isbn;
@NotBlank
private String publisher;
@NotBlank
private String publishedDate;

}
