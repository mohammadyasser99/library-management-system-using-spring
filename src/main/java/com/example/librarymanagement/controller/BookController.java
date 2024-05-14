package com.example.librarymanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;

    //adding book
    @PostMapping("/books")
    public ResponseEntity<?> addbook(@RequestBody @Valid Book book,
     BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation failed: " 
            + bindingResult.getFieldError().getDefaultMessage());
        }
      return  bookService.addBook(book);  
    }
//getting all books
    @GetMapping("/books")
    public ResponseEntity< List<Book> > getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

}
