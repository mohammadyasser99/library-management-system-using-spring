package com.example.librarymanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;


//getting all books
@PostMapping("/books")
public ResponseEntity<?> addBook(@RequestParam("title") String title, @RequestParam("author") String author,
                                 @RequestParam("isbn") String isbn, @RequestParam("publisher") String publisher,
                                 @RequestParam("publishedDate") Date publishedDate, @RequestParam("image") MultipartFile image) throws SQLException, IOException {
    return bookService.addBook(title, author, isbn, publisher, publishedDate, image);

}
@RequestMapping("/books")
public ResponseEntity<List<Book>> getBooks() {
    return bookService.getBooks();
}


    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getonebook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id,
                                        @RequestParam("title") String title, @RequestParam("author") String author,
                                        @RequestParam("isbn") String isbn, @RequestParam("publisher") String publisher,
                                        @RequestParam("publishedDate") Date publishedDate, @RequestParam("image") MultipartFile image) {
        return bookService.updateBook(id, title, author, isbn, publisher, publishedDate, image);
    }





}
